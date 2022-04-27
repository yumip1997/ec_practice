package com.himart.backend.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrdInfoDto {

    private int prdId;
    private String prdNm;
    private String brdNm;
    private int prdSlPrc;
    private int cateId;
}
