package com.himart.backend.promotion.utils.factory.impl;

import com.himart.backend.promotion.dto.request.PrmRequestBase;
import com.himart.backend.promotion.dto.response.CartCouponResponseVO;
import com.himart.backend.promotion.dto.response.ResponseBaseVO;
import com.himart.backend.promotion.utils.factory.Calculation;
import org.springframework.stereotype.Component;

@Component
public class CartCouponCalculation implements Calculation {

    @Override
    public ResponseBaseVO getCalculationData(PrmRequestBase prmRequestBase) {
        return new CartCouponResponseVO();
    }

}
