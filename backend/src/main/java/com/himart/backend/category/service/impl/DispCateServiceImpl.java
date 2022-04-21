package com.himart.backend.category.service.impl;

import com.himart.backend.category.dao.DispCateDao;
import com.himart.backend.category.dto.DispCateDto;
import com.himart.backend.category.service.DispCateService;
import com.himart.backend.category.vo.DispCateVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class DispCateServiceImpl implements DispCateService {

    private final DispCateDao dispCateDao;

    @Override
    public List<DispCateVO> getDispCateList() {
        List<DispCateVO> dispList = dispCateDao.getDispCateList();
        return dispCateDao.getDispCateList();
    }

    private List<DispCateDto> makeCateDtoList(List<DispCateVO> cateVOList){
        List<DispCateDto> cateDtoList = new ArrayList<>();
        setLgDepthCate(cateVOList, cateDtoList);
        return cateDtoList;
    };

    private void setLgDepthCate(List<DispCateVO> cateVOList, List<DispCateDto> cateDtoList){
        List<DispCateDto> lgDepthCateList = cateVOList.stream()
                .filter(this::isLgDepth)
                .map(cateVO -> DispCateDto.builder()
                        .cateId(cateVO.getCateId())
                        .cateNm(cateVO.getCateNm())
                        .subCateList(new ArrayList<>())
                        .build())
                .collect(Collectors.toList());
        cateDtoList.addAll(lgDepthCateList);
    };

    private void setMdDepthCate(List<DispCateVO> cateVOList, List<DispCateDto> cateDtoList){
        List<DispCateVO> mdDepthCateList = cateVOList.stream()
                .filter(this::isMdDepth)
                .collect(Collectors.toList());

        for(DispCateVO dispCateVO : mdDepthCateList){
            //상위 카테고리를 찾는다
            cateDtoList.stream()
                    .filter(cate -> dispCateVO.getLgCateNo().equals(cate.getCateNo()))
                    .forEach(cate -> {
                    });

        }

    }
    //TODO 더 좋은 방법 생각해보기
    private boolean isLgDepth(DispCateVO dispCateVO){
        return !ObjectUtils.isEmpty(dispCateVO.getLgCateNo())
                && ObjectUtils.isEmpty(dispCateVO.getMdCateNo())
                && ObjectUtils.isEmpty(dispCateVO.getSmCateNo());
    }

    private boolean isMdDepth(DispCateVO dispCateVO){
        return !ObjectUtils.isEmpty(dispCateVO.getLgCateNo())
                && !ObjectUtils.isEmpty(dispCateVO.getMdCateNo())
                && ObjectUtils.isEmpty(dispCateVO.getSmCateNo());
    }

    private boolean isSmDepth(DispCateVO dispCateVO){
        return !ObjectUtils.isEmpty(dispCateVO.getLgCateNo())
                && !ObjectUtils.isEmpty(dispCateVO.getMdCateNo())
                && !ObjectUtils.isEmpty(dispCateVO.getSmCateNo());
    }
}
