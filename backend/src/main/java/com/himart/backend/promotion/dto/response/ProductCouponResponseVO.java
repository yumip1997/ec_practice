package com.himart.backend.promotion.dto.response;

import com.himart.backend.product.dto.Product;
import com.himart.backend.promotion.dto.ProductCouponVO;
import com.himart.backend.promotion.dto.PromotionVO;
import com.himart.backend.promotion.dto.request.PrmRequestBase;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductCouponResponseVO extends ResponseBaseVO {

    private List<ProductCouponVO> productCouponVOList;

}
