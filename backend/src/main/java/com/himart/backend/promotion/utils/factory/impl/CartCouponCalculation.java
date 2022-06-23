package com.himart.backend.promotion.utils.factory.impl;

import com.himart.backend.promotion.code.PromotionType;
import com.himart.backend.promotion.dto.request.PrmRequestBase;
import com.himart.backend.promotion.dto.response.CartCouponResponseVO;
import com.himart.backend.promotion.dto.response.ResponseBaseVO;
import com.himart.backend.promotion.utils.factory.Calculation;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CartCouponCalculation implements Calculation {

    @Override
    public ResponseBaseVO getCalculationData(PrmRequestBase prmRequestBase) {
        log.info("장바구니 할인금액 계산");
        return new CartCouponResponseVO();
    }

    @Override
    public PromotionType getType() {
        return PromotionType.CART_COUPON;
    }

}
