package com.himart.backend.promotion.utils.factory;

import com.himart.backend.promotion.code.PromotionType;
import com.himart.backend.promotion.dto.request.PrmRequestBase;
import com.himart.backend.promotion.utils.factory.impl.CartCouponCalculation;
import com.himart.backend.promotion.utils.factory.impl.PriceDiscountCalculation;
import com.himart.backend.promotion.utils.factory.impl.ProductCouponCalculation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CalculationFactory {

    private final PriceDiscountCalculation priceDiscountCalculation;
    private final ProductCouponCalculation productCouponCalculation;
    private final CartCouponCalculation cartCouponCalculation;

    private Map<PromotionType, Calculation> map = new HashMap<>();

    @PostConstruct
    void init(){
        map.put(PromotionType.PRICE_DISCOUNT, priceDiscountCalculation);
        map.put(PromotionType.PROUDCT_COUPON, productCouponCalculation);
        map.put(PromotionType.CART_COUPNT, cartCouponCalculation);
    }

    public Calculation getCalculation(String prmTypeCode){
        PromotionType promotionType = PromotionType.findPromotionType(prmTypeCode);
        return map.get(promotionType);
    }
}
