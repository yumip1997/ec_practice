package com.himart.backend.promotion.controller;

import com.himart.backend.promotion.dto.request.PrmRequestBase;
import com.himart.backend.promotion.dto.response.CartCouponResponseVO;
import com.himart.backend.promotion.dto.response.PriceDiscountResponseVO;
import com.himart.backend.promotion.dto.response.ProductCouponResponseVO;
import com.himart.backend.promotion.dto.response.ResponseBaseVO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PromotionControllerTest {

    @Autowired
    private PromotionController promotionController;

    @Test
    @DisplayName("가격조정 프로모션 요청 시 PriceDiscountResponseVO 타입의 객체가 반환된다.")
    void price_distcount_test(){
        PrmRequestBase prmRequestBase = PrmRequestBase.builder().prmTypeCode("PD").build();

        ResponseBaseVO responseBaseVO = promotionController.getPromotion(prmRequestBase);

        Assertions.assertThat(responseBaseVO).isInstanceOf(PriceDiscountResponseVO.class);
    }

    @Test
    @DisplayName("상품쿠폰 프로모션 요청 시 ProductCouponResponseVO 타입의 객체가 반환된다.")
    void product_coupon_test(){
        PrmRequestBase prmRequestBase = PrmRequestBase.builder().prmTypeCode("PC").build();

        ResponseBaseVO responseBaseVO = promotionController.getPromotion(prmRequestBase);

        Assertions.assertThat(responseBaseVO).isInstanceOf(ProductCouponResponseVO.class);
    }

    @Test
    @DisplayName("장바구니 프로모션 요청 시 CartCouponResponseVO 타입의 객체가 반환된다.")
    void cart_coupon_test(){
        PrmRequestBase prmRequestBase = PrmRequestBase.builder().prmTypeCode("CC").build();

        ResponseBaseVO responseBaseVO = promotionController.getPromotion(prmRequestBase);

        Assertions.assertThat(responseBaseVO).isInstanceOf(CartCouponResponseVO.class);
    }
}