package com.himart.backend.category.service;

import com.himart.backend.category.dto.DispCateDto;
import com.himart.backend.category.vo.DispCateVO;

import java.util.List;

public interface DispCateService {

    List<DispCateVO> getDispCateList();
}
