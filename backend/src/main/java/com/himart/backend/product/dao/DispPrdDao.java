package com.himart.backend.product.dao;

import com.himart.backend.product.dto.PrdDtlDto;
import com.himart.backend.product.dto.PrdInfoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DispPrdDao {

    PrdDtlDto selectPrdDtl(int prdId);

    List<PrdInfoDto> selectPrdListByCate(int cateId);
}
