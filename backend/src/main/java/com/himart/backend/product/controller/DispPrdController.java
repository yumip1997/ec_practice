package com.himart.backend.product.controller;


import com.himart.backend.product.dto.PrdDtlDto;
import com.himart.backend.product.dto.PrdInfoDto;
import com.himart.backend.product.service.DispPrdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prd")
public class DispPrdController {

    private final DispPrdService dispPrdService;

    @GetMapping("/list")
    List<PrdInfoDto> getPrdListByCate(@RequestParam int cateId){
        return dispPrdService.getPrdListByCate(cateId);
    }

    @GetMapping("/prd")
    PrdDtlDto getPrdDtl(@RequestParam("prdId")int prdId){
        PrdDtlDto prdDtlDto = dispPrdService.getPrdDtl(prdId);
        return prdDtlDto;
    }
}
