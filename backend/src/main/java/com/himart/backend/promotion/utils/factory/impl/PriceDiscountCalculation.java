package com.himart.backend.promotion.utils.factory.impl;

import com.himart.backend.product.dto.Product;
import com.himart.backend.promotion.code.PromotionType;
import com.himart.backend.promotion.dao.PrmDao;
import com.himart.backend.promotion.dto.ApplicablePromotionVO;
import com.himart.backend.promotion.dto.PromotionVO;
import com.himart.backend.promotion.dto.request.PrmRequestBase;
import com.himart.backend.promotion.dto.response.PriceDiscountResponseVO;
import com.himart.backend.promotion.dto.response.ResponseBaseVO;
import com.himart.backend.promotion.utils.factory.Calculation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
@Log4j2
public class PriceDiscountCalculation implements Calculation {

    private final PrmDao prmDao;

    @Override
    public ResponseBaseVO getCalculationData(PrmRequestBase prmRequestBase) {
        log.info("가격조정 할인금액 계산");

        PriceDiscountResponseVO priceDiscountResponseVO = new PriceDiscountResponseVO();

        List<Product> priceDiscountAppliedProductList = new ArrayList<>();
        List<ApplicablePromotionVO> prmList = getApplicablePromotionList(prmRequestBase);

        for (ApplicablePromotionVO applicablePromotionVO : prmList) {
            Product product = setUpMaxBnfDiscountPrice(applicablePromotionVO);
            priceDiscountAppliedProductList.add(product);
        }

        priceDiscountResponseVO.setMemberNo(prmRequestBase.getMemberNo());
        priceDiscountResponseVO.setProductList(priceDiscountAppliedProductList);

        return priceDiscountResponseVO;
    }

    @Override
    public PromotionType getType() {
        return PromotionType.PRICE_DISCOUNT;
    }

    private Product setUpMaxBnfDiscountPrice(ApplicablePromotionVO applicablePromotionVO){
        //상품 1개당 적용 가능 가격조정 프로모션은 N개
        Product product = applicablePromotionVO.getProduct();
        List<PromotionVO> applicablePriceDiscountPrmList = applicablePromotionVO.getPromotionVOList();

        for (PromotionVO promotionVO : applicablePriceDiscountPrmList) {
            setDiscountedPrice(product.getProductPrice(), promotionVO);
        }

        //적용가능한 가격조정 금액 중 할인혜택이 가장 큰 가격조정 프로모션을 가져온다.
        PromotionVO maxBnfPromotion = getMaxBenefitPrm(applicablePriceDiscountPrmList);
        Long discountedPrice = maxBnfPromotion.getDiscountedPrice();

        //할인혜택이 가장 큰 가격조정 금액으로 Product의 가격조정금액을 셋팅한다.
        setProductDiscountedPrice(product, discountedPrice);

        return product;
    }

    private void setProductDiscountedPrice(Product product, Long discountedPrice){
        product.setDiscountedPrice(discountedPrice);
    }

    public List<ApplicablePromotionVO> getApplicablePromotionList(PrmRequestBase prmRequestBase) {
        //TODO prmDao.getApplicablePromotionList
        return new ArrayList<>();
    }

}
