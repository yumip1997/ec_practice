package com.himart.backend.claim.utils.processor.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ClaimNumFlagCode {

    //일반상품주문취소완료
    GCC(Boolean.TRUE),
    //모바일쿠폰주문취소접수
    MCA(Boolean.TRUE),
    //모바일쿠폰주문취소완료
    MCC(Boolean.FALSE),

    //반품접수
    RA(Boolean.TRUE),
    //반품완료
    RC(Boolean.FALSE),
    //반품철회
    RW(Boolean.TRUE),

    //교환접수
    EA(Boolean.TRUE),
    //교환철회
    EC(Boolean.TRUE);

    private final Boolean flag;

}
