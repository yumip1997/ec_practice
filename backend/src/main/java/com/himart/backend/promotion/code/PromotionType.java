package com.himart.backend.promotion.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PromotionType {

    //가격조정
    PRICE_DISCOUNT("PD"),
    //상품쿠폰
    PROUDCT_COUPON("PC"),
    //장바구니쿠폰
    CART_COUPNT("CC");

    private final String code;
}
