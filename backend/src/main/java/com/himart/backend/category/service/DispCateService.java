package com.himart.backend.category.service;

import com.himart.backend.category.dto.HierarchyDispCateDto;

import java.util.List;

public interface DispCateService {

    List<HierarchyDispCateDto> getDispCateList();
}
