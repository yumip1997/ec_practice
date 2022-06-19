package com.himart.backend.promotion.dto.request;

import com.himart.backend.product.dto.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PrmRequestBase {

    private String memberNo;
    private List<Product> productList;
    private String prmTypeCode;
}
