package com.himart.backend.promotion.utils.factory.impl;

import com.himart.backend.product.dto.Product;
import com.himart.backend.promotion.dao.PrmDao;
import com.himart.backend.promotion.dto.ApplicablePromotionVO;
import com.himart.backend.promotion.dto.ProductCouponVO;
import com.himart.backend.promotion.dto.PromotionVO;
import com.himart.backend.promotion.dto.request.PrmRequestBase;
import com.himart.backend.promotion.dto.response.ProductCouponResponseVO;
import com.himart.backend.promotion.dto.response.ResponseBaseVO;
import com.himart.backend.promotion.utils.factory.Calculation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductCouponCalculation implements Calculation {
    
    private final PrmDao prmDao;


    @Override
    public ResponseBaseVO getCalculationData(PrmRequestBase prmRequestBase) {
        ProductCouponResponseVO productCouponResponseVO = new ProductCouponResponseVO();
        
        List<ApplicablePromotionVO> applicablePrmList = getApplicablePromotionList(prmRequestBase);
        List<ProductCouponVO> productCouponVOList = new ArrayList<>();

        for (ApplicablePromotionVO applicablePromotionVO : applicablePrmList) {
            //상품 1개 , 적용가능한 상품쿠폰 N개
            Product product = applicablePromotionVO.getProduct();
            Long productPrice = product.getProductPrice();
            List<PromotionVO> promotionVOList = applicablePromotionVO.getPromotionVOList();

            //쿠폰적용금액 셋팅
            setDiscountedPriceOfPrdCupList(productPrice, promotionVOList);

            if(!CollectionUtils.isEmpty(promotionVOList)){
                PromotionVO maxBnfPrm = getMaxBenefitPrm(promotionVOList);
                maxBnfPrm.setMaxBenefitYn("Y");
            }

            ProductCouponVO productCouponVO = setUpProductCouponVO(product, promotionVOList);
            productCouponVOList.add(productCouponVO);
        }

        productCouponResponseVO.setMemberNo(prmRequestBase.getMemberNo());
        productCouponResponseVO.setProductCouponVOList(productCouponVOList);

        return productCouponResponseVO;
    }
    

    public List<ApplicablePromotionVO> getApplicablePromotionList(PrmRequestBase prmRequestBase) {
        //TODO prmDao.getApplicablePromotionList
        return new ArrayList<>();
    }

    private void setDiscountedPriceOfPrdCupList(Long productPrice, List<PromotionVO> promotionVOList){
        for(PromotionVO promotionVO : promotionVOList){
            setDiscountedPrice(productPrice, promotionVO);
        }
    }

    private ProductCouponVO setUpProductCouponVO(Product product, List<PromotionVO> promotionVOList){
        return ProductCouponVO.builder().product(product).promotionVOList(promotionVOList).build();
    }
    
}
