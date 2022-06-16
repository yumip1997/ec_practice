package com.himart.backend.claim.com.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ClaimStatusCode {

    //주문취소
    CANCEL("C"),
    //반품접수
    RETURN_ACCEPT(""),
    //반품완료
    RETURN_COMPLETE("RC"),

    //교환접수
    EXCHANGE_ACCEPT("X"),
    //교환철회
    EXCHANGE_WITHDRAWAL("XC");

    private final String code;
}
