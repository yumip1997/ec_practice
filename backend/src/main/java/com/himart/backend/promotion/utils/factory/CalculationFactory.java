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
public class CalculationFactory {

    private final Map<PromotionType, Calculation> map = new HashMap<>();

    public CalculationFactory(List<Calculation> calculation){
        calculation.forEach(c -> map.put(c.getType(), c));
    }

    public Calculation getCalculation(PromotionType prmTypeCode){
        return map.get(prmTypeCode);
    }
}
