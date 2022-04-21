package com.himart.backend.product.dao;

import com.himart.backend.product.dto.PrdDtlDto;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DispPrdDao {

    @Select("select * from prdDtl where prd_id = #{prdId}")
    PrdDtlDto getPrdDtl(int prdId);
}
