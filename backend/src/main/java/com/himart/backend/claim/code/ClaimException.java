package com.himart.backend.claim.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ClaimException {

    INVALID_CLAIM_TYPE ("클레임 타입이 올바르지 않습니다!"),
    INVALID_ORDER_STATUS("클레임 가능한 주문 상태가 아닙니다!"),
    INVALID_PRD_TPYE("상품 유형이 올바르지 않습니다!"),
    INVALID_AMOUNT("금액이 일치하지 않습니다");

    public final String EXCEPTION_MSG;
}
