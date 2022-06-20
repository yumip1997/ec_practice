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
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CalculationFactory {

    private Map<PromotionType, Calculation> map = new HashMap<>();
    private final List<Calculation> calculation;

    @PostConstruct
    void init(){
        calculation.stream().forEach(c -> map.put(c.getType(), c));
    }

    public Calculation getCalculation(String prmTypeCode){
        return map.get(prmTypeCode);
    }
}
