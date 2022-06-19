package com.himart.backend.promotion.utils.factory.impl;

import com.himart.backend.product.dto.Product;
import com.himart.backend.promotion.dao.PrmDao;
import com.himart.backend.promotion.dto.ApplicablePromotionVO;
import com.himart.backend.promotion.dto.PromotionVO;
import com.himart.backend.promotion.dto.request.PrmRequestBase;
import com.himart.backend.promotion.dto.response.PriceDiscountResponseVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PriceDiscountCalculationTest {

    private PriceDiscountCalculation priceDiscountCalculation;
    private PrmDao prmDao;
    private List<ApplicablePromotionVO> dummyList = new ArrayList<>();

    @BeforeEach
    void init(){
        dummyList = getDummyList();
        prmDao = prmRequestBase -> dummyList;
        priceDiscountCalculation = new PriceDiscountCalculation(prmDao);
    }

    private List<ApplicablePromotionVO> getDummyList(){
        ApplicablePromotionVO applicablePromotionVO = new ApplicablePromotionVO();
        Product product1 = Product.builder().productNo("1").productNm("상품1").productPrice(1000L).build();
        PromotionVO promotionVO1 = PromotionVO.builder().prmNo(1L).prmNm("정액프로모션가격조정").dcCode("FD").discountValue(100L).build();
        PromotionVO promotionVO2 = PromotionVO.builder().prmNo(2L).prmNm("정률프로모션가격조정").dcCode("RD").discountValue(30L).build();

        applicablePromotionVO.setProduct(product1);
        applicablePromotionVO.setPromotionVOList(Arrays.asList(promotionVO1, promotionVO2));


        ApplicablePromotionVO applicablePromotionVO2 = new ApplicablePromotionVO();
        Product product2 = Product.builder().productNo("1").productNm("상품2").productPrice(2000L).build();
        applicablePromotionVO2.setProduct(product2);
        applicablePromotionVO2.setPromotionVOList(new ArrayList<>());


        return Arrays.asList(applicablePromotionVO, applicablePromotionVO2);
    }

    @Test
    void max_bnf_test(){
        Product product = dummyList.get(0).getProduct();
        List<PromotionVO> promotionVOList = dummyList.get(0).getPromotionVOList();
        for (PromotionVO promotionVO : promotionVOList) {
            priceDiscountCalculation.setDiscountedPrice(product.getProductPrice(), promotionVO);
        }
        PromotionVO prm = priceDiscountCalculation.getMaxBenefitPrm(promotionVOList);
        Assertions.assertThat(prm.getPrmNo()).isEqualTo(2L);
    }

    @Test
    @DisplayName("적용가능한 가격조정 프로모션이 없을 경우 빈 PrmotionVO가 반환된다.")
    void null_max_bnf_test(){
        Product product = dummyList.get(1).getProduct();
        List<PromotionVO> promotionVOList = dummyList.get(1).getPromotionVOList();
        for (PromotionVO promotionVO : promotionVOList) {
            priceDiscountCalculation.setDiscountedPrice(product.getProductPrice(), promotionVO);
        }
        PromotionVO prm = priceDiscountCalculation.getMaxBenefitPrm(promotionVOList);
        assertTrue(ObjectUtils.isEmpty(prm.getPrmNo()));
        assertTrue(ObjectUtils.isEmpty(prm.getDiscountedPrice()));
    }

    @Test
    @DisplayName("가격조정 프로모션이 적용된 상품의 가격정보 테스트")
    void price_discout_test(){
        PrmRequestBase prmRequestBase = PrmRequestBase.builder().build();
        PriceDiscountResponseVO priceDiscountResponseVO = (PriceDiscountResponseVO) priceDiscountCalculation.getCalculationData(prmRequestBase);
        List<Product> prdList = priceDiscountResponseVO.getProductList();

        Assertions.assertThat(prdList.get(0).getDiscountedPrice()).isEqualTo(700L);
        Assertions.assertThat(prdList.get(1).getDiscountedPrice()).isEqualTo(null);
    }

}