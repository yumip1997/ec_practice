package com.himart.backend.promotion.utils.factory;

import com.himart.backend.promotion.code.DcCode;
import com.himart.backend.promotion.code.PromotionType;
import com.himart.backend.promotion.dto.ApplicablePromotionVO;
import com.himart.backend.promotion.dto.PromotionVO;
import com.himart.backend.promotion.dto.request.PrmRequestBase;
import com.himart.backend.promotion.dto.response.ResponseBaseVO;

import java.util.Comparator;
import java.util.List;

public interface Calculation {

    ResponseBaseVO getCalculationData(PrmRequestBase prmRequestBase);

    PromotionType getType();

    default PromotionVO getMaxBenefitPrm(List<PromotionVO> promotionVOList){
        return promotionVOList.stream()
                .min(Comparator.comparingLong(PromotionVO::getDiscountedPrice))
                .orElse(PromotionVO.builder().build());
    }

    default PromotionVO setDiscountedPrice(Long productPrice, PromotionVO promotionVO){
        Long discountedPrice = getDiscountPrice(productPrice, promotionVO);
        promotionVO.setDiscountedPrice(discountedPrice);

        return promotionVO;
    }

    default Long getDiscountPrice(Long productPrice, PromotionVO promotionVO){
        String code = promotionVO.getDcCode();
        Long discountValue = promotionVO.getDiscountValue();

        return DcCode.getDiscountFunction(code).apply(productPrice, discountValue);
    }

}
