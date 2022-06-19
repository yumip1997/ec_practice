package com.himart.backend.promotion.dao;

import com.himart.backend.promotion.dto.ApplicablePromotionVO;
import com.himart.backend.promotion.dto.request.PrmRequestBase;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PrmDao {

    List<ApplicablePromotionVO> getApplicablePromotionList(PrmRequestBase prmRequestBase);

}
