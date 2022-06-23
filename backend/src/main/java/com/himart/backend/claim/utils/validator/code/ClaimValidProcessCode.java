package com.himart.backend.claim.utils.validator.code;

import com.himart.backend.claim.com.code.ClaimProcessCode;
import com.himart.backend.claim.com.code.ProductTypeCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Getter
public enum ClaimValidProcessCode {

    //일반상품주문취소완료 - 출고지시 이전의 상태들, 일반상품
    GCC(Arrays.asList(ClaimProcessCode.ORDER_COMPLETE.code)),
    //모바일쿠폰주문취소접수 - 발송완료 이전의 상태들, 모바일쿠폰상품
    MCA(Arrays.asList(ClaimProcessCode.ORDER_COMPLETE.code)),
    //모바일쿠폰주문취소완료
    MCC(Arrays.asList(ClaimProcessCode.CANCEL_ACCEPT.code)),

    //반품접수 - 배송완료까지의 상태들
    RA(Arrays.asList(ClaimProcessCode.DELIVERY_COMPLETE.code)),
    //반품철회
    RW(Arrays.asList(ClaimProcessCode.RETURN_ACCEPT.code)),

    //교환접수
    EA(Arrays.asList(ClaimProcessCode.DELIVERY_COMPLETE.code)),
    //교환철회
    EC(Arrays.asList(ClaimProcessCode.EXCHANGE_ACCEPT.code));

    private final List<String> validOrderStatusList;
}
