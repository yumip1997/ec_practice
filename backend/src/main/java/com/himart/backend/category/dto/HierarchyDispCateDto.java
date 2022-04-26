package com.himart.backend.category.dto;

import com.himart.backend.category.vo.DispCateVO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class HierarchyDispCateDto extends DispCateVO {

    private String label;
    private List<HierarchyDispCateDto> children;
}
