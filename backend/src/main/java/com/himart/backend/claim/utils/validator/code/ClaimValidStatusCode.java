package com.himart.backend.claim.utils.validator.code;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public enum ClaimValidStatusCode {

    //일반상품주문취소완료
    GCC(Arrays.asList()),
    //모바일쿠폰주문취소접수
    MCA(Arrays.asList()),
    //모바일쿠폰주문취소완료
    MCC(Arrays.asList()),

    //반품접수
    RA(Arrays.asList()),
    //반품완료
    RC(Arrays.asList()),
    //반품철회
    RW(Arrays.asList()),

    //교환접수
    EA(Arrays.asList()),
    //교환철회
    EC(Arrays.asList());

    private final List<String> validStatus;
}
