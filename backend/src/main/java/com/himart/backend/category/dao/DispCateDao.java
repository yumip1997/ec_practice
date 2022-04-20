package com.himart.backend.category.dao;

import com.himart.backend.category.dto.DispCateDto;
import com.himart.backend.category.vo.DispCateVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface DispCateDao {
    @Select("select * from cate")
    List<DispCateVO> getDispCateList();
}
