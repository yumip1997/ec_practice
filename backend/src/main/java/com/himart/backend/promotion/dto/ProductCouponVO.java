package com.himart.backend.promotion.dto;

import com.himart.backend.product.dto.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ProductCouponVO {

    private Product product;
    private List<PromotionVO> promotionVOList;

}
