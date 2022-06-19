package com.himart.backend.promotion.dto;

import com.himart.backend.product.dto.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ApplicablePromotionVO {

    private Product product;
    private List<PromotionVO> promotionVOList;

}
