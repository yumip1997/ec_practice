package com.himart.backend.category.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class DispCateDto {

    private Integer cateId;
    private String cateNm;
    private Integer cateNo;
    private List<DispCateDto> subCateList;

}
