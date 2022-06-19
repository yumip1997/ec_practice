package com.himart.backend.promotion.dao;

import com.himart.backend.promotion.dto.ApplicablePromotionVO;
import com.himart.backend.promotion.dto.request.PrmRequestBase;

import java.util.List;

public interface PrmDao {

    List<ApplicablePromotionVO> getApplicablePromotionList(PrmRequestBase prmRequestBase);

}
