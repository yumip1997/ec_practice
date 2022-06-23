package com.himart.backend.claim.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ClaimProcessCode {

    //주문대기
    ORDER_WAITING("10"),
    //주문완료
    ORDER_COMPLETE("20"),
    //취소요청
    CANCEL_REQUEST("30"),
    //취소완료
    CANCEL_COMPLETE("40"),
    //배송완료
    DELIVERY_COMPLETE("50"),
    //반품접수
    RETURN_ACCEPT("60"),
    //교환접수
    EXCHANGE_ACCEPT("70"),
    //교환철회
    EXCHANGE_WITHDRAWAL("80");

    public final String code;
}
