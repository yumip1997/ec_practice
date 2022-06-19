package com.himart.backend.product.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Product {

    private String productNo;
    private String productNm;
    private Long productPrice;
    private Long discountedPrice;

}
