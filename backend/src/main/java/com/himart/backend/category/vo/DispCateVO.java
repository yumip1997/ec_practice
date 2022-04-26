package com.himart.backend.category.vo;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@Alias("DispCateVO")
public class DispCateVO {

    private int cateId;
    private String cateNm;
    private int cateDepth;
    private int parentCateId;
    private boolean cateLeafF;
    private String catePath;

}
