package com.himart.backend.promotion.controller;

import com.himart.backend.promotion.dto.request.PrmRequestBase;
import com.himart.backend.promotion.dto.response.ResponseBaseVO;
import com.himart.backend.promotion.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PromotionController {

    private final PromotionService promotionService;

    public ResponseBaseVO getPromotion(PrmRequestBase prmRequestBase){
        return promotionService.getCalculationData(prmRequestBase);
    }


}
