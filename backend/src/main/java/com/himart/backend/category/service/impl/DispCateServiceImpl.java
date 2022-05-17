package com.himart.backend.category.service.impl;

import com.himart.backend.category.dao.DispCateDao;
import com.himart.backend.category.service.DispCateService;
import com.himart.backend.category.vo.DispCateVO;
import com.himart.backend.category.dto.HierarchyDispCateDto;
import com.himart.backend.category.util.HierarchyCategoryMaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DispCateServiceImpl implements DispCateService {

    private final DispCateDao dispCateDao;
    private final HierarchyCategoryMaker hierarchyCategoryMaker;

    @Override
    public List<HierarchyDispCateDto> getDispCateList() {
        List<DispCateVO> dispCateVOList = dispCateDao.selectDispCateList();
        //TODO 메서드 하나로 만드는 방법 고민하기
        hierarchyCategoryMaker.setUpHierarchyCate(dispCateVOList);
        return hierarchyCategoryMaker.getHierarchyCate();
    }
}
