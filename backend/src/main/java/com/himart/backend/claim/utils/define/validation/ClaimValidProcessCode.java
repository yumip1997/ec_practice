package com.himart.backend.claim.utils.define.validation;

import com.himart.backend.claim.code.ClaimProcessCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Getter
public enum ClaimValidProcessCode {

    //일반상품주문취소완료 - 주문대기, 주문완료
    GCC(Arrays.asList(ClaimProcessCode.ORDER_COMPLETE.code)),
    //모바일쿠폰주문취소접수
    MCA(Arrays.asList(ClaimProcessCode.ORDER_COMPLETE.code)),
    //모바일쿠폰주문취소완료
    MCC(Arrays.asList(ClaimProcessCode.ORDER_COMPLETE.code)),

    //반품접수
    RA(Arrays.asList(ClaimProcessCode.DELIVERY_COMPLETE.code)),
    //반품철회
    RW(Arrays.asList(ClaimProcessCode.RETURN_ACCEPT.code)),

    //교환접수
    EA(Arrays.asList(ClaimProcessCode.DELIVERY_COMPLETE.code)),
    //교환철회
    EW(Arrays.asList(ClaimProcessCode.EXCHANGE_ACCEPT.code));

    private final List<String> validOrderStatusList;
}
