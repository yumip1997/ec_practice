package com.himart.backend.promotion.controller;

import com.himart.backend.promotion.dto.request.PrmRequestBase;
import com.himart.backend.promotion.dto.response.ResponseBaseVO;
import com.himart.backend.promotion.service.PromotionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PromotionController {

    private final PromotionService promotionService;

    @PostMapping("/promotion")
    public ResponseBaseVO getPromotion(@RequestBody PrmRequestBase prmRequestBase){
        return promotionService.getCalculationData(prmRequestBase);
    }

}
