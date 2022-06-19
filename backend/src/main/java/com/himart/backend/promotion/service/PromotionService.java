package com.himart.backend.promotion.service;

import com.himart.backend.promotion.dto.request.PrmRequestBase;
import com.himart.backend.promotion.dto.response.ResponseBaseVO;
import com.himart.backend.promotion.utils.factory.Calculation;
import com.himart.backend.promotion.utils.factory.CalculationFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PromotionService {

    private final CalculationFactory calculationFactory;

    public ResponseBaseVO getCalculationData(PrmRequestBase prmRequestBase){
        Calculation calculation = calculationFactory.getCalculation(prmRequestBase.getPrmTypeCode());
        return calculation.getCalculationData(prmRequestBase);
    }

}
