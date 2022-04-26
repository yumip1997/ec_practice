package com.himart.backend.category.util;

import com.himart.backend.category.dto.HierarchyDispCateDto;
import com.himart.backend.category.vo.DispCateVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class HierarchyCategoryMaker {

    private final Map<Integer, HierarchyDispCateDto> cateMap = new HashMap<>();
    private final Map<Integer, List<Integer>> cateNodeMap = new HashMap<>();
    private final Map<Integer, Boolean> visitedMap = new HashMap<>();

    public void setUpHierarchyCate(List<DispCateVO> dispCateVOList){
        initField(dispCateVOList);
        makeHierarchyCategory(dispCateVOList);
    }
    
    private void initField(List<DispCateVO> dispCateVOList){
        initCateMap(dispCateVOList);
        initVisitedMap(dispCateVOList);
        initCateNodeMap(dispCateVOList);
    }

    private void initCateMap(List<DispCateVO> dispCateVOList){
        for(DispCateVO dispCateVO : dispCateVOList){
            HierarchyDispCateDto hierarchyDispCateDto = HierarchyDispCateDto.builder()
                    .label(dispCateVO.getCateNm())
                    .children(new ArrayList<>()).build();
            BeanUtils.copyProperties(dispCateVO, hierarchyDispCateDto);
            cateMap.put(dispCateVO.getCateId(), hierarchyDispCateDto);
        }
    }

    private void initVisitedMap(List<DispCateVO> dispCateVOList){
        for(DispCateVO dispCateVO : dispCateVOList){
            visitedMap.put(dispCateVO.getCateId(), false);
        }
    }

    private void initCateNodeMap(List<DispCateVO> dispCateVOList){
        for(DispCateVO dispCateVO : dispCateVOList){
            cateNodeMap.put(dispCateVO.getCateId(), new ArrayList<>());
        }

        for(DispCateVO dispCateVO : dispCateVOList){
            int parentId = dispCateVO.getParentCateId();
            if(parentId == 0){
                continue;
            }
            cateNodeMap.get(parentId).add(dispCateVO.getCateId());
        }
    }
    
    private void makeHierarchyCategory(List<DispCateVO> dispCateVOList){
       List<Integer> topLevelCateIdList = getTopLevelCateId(dispCateVOList);
       for(Integer cateId : topLevelCateIdList){
           dfs(cateMap.get(cateId));
       }
    }

    private void dfs(HierarchyDispCateDto dto){

        Integer currentId = dto.getCateId();
        visitedMap.replace(currentId, true);

        if(dto.isCateLeafF()){
            return;
        }

        List<Integer> childCateIdList = cateNodeMap.get(currentId);
        if(childCateIdList.isEmpty()){
            return;
        }

        for(Integer childCateId : childCateIdList){
            if(!visitedMap.get(childCateId)){
                dto.getChildren().add(cateMap.get(childCateId));
                dfs(cateMap.get(childCateId));
            }
        }
    }

    private List<Integer> getTopLevelCateId(List<DispCateVO> dispCateVOList){
        return dispCateVOList.stream()
                .filter(this::isParent)
                .map(DispCateVO::getCateId)
                .collect(Collectors.toList());
    }
    
    private boolean isParent(DispCateVO dispCateVO){
        return dispCateVO.getParentCateId() == 0;
    }

    public List<HierarchyDispCateDto> getHierarchyCate(){
        return cateMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(this::isParent)
                .collect(Collectors.toList());
    }
}
