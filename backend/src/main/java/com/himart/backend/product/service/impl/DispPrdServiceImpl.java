package com.himart.backend.product.service.impl;

import com.himart.backend.product.dao.DispPrdDao;
import com.himart.backend.product.dto.PrdDtlDto;
import com.himart.backend.product.service.DispPrdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DispPrdServiceImpl implements DispPrdService {

    private final DispPrdDao dispPrdDao;

    @Override
    public PrdDtlDto getPrdDtl(int prdId) {
        return dispPrdDao.getPrdDtl(prdId);
    }
}
