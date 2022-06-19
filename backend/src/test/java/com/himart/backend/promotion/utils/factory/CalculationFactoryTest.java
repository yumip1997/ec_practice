package com.himart.backend.promotion.utils.factory;

import com.himart.backend.promotion.utils.factory.impl.CartCouponCalculation;
import com.himart.backend.promotion.utils.factory.impl.PriceDiscountCalculation;
import com.himart.backend.promotion.utils.factory.impl.ProductCouponCalculation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalculationFactoryTest {

    @Autowired
    private CalculationFactory calculationFactory;

    @Test
    @DisplayName("가격조정 프로모션 요청 시 PriceDiscountCalculation 타입의 객체가 반환된다.")
    void price_discount_test(){
        String prmType = "PD";

        Calculation calculation = calculationFactory.getCalculation(prmType);

        Assertions.assertThat(calculation).isInstanceOf(PriceDiscountCalculation.class);
    }

    @Test
    @DisplayName("상품쿠폰 요청 시 ProductCouponCalculation 타입의 객체가 반환된다.")
    void product_coupon_test(){
        String prmType = "PC";

        Calculation calculation = calculationFactory.getCalculation(prmType);

        Assertions.assertThat(calculation).isInstanceOf(ProductCouponCalculation.class);
    }

    @Test
    @DisplayName("장바구니쿠폰 요청 시 CartCouponCalculation 타입의 객체가 반환된다.")
    void cart_coupon_test(){
        String prmType = "CC";

        Calculation calculation = calculationFactory.getCalculation(prmType);

        Assertions.assertThat(calculation).isInstanceOf(CartCouponCalculation.class);
    }
}