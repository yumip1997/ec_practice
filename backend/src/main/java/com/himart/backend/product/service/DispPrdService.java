package com.himart.backend.product.service;

import com.himart.backend.product.dto.PrdDtlDto;
import com.himart.backend.product.dto.PrdInfoDto;

import java.util.List;

public interface DispPrdService {

    PrdDtlDto getPrdDtl(int prdId);

    List<PrdInfoDto> getPrdListByCate(int cateId);
}
