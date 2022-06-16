package com.himart.backend.claim.com.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ClaimProcessCode {

    //취소접수
    CANCEL_ACCEPT("CA"),
    //발송완료
    SEND_COMPLETE("SC"),
    //반품접수
    RETURN_ACCEPT("RA"),
    //교환접수
    EXCHANGE_ACCEPT("EA"),
    //회수지시
    RETRIEVE_INSTRUCT("RTI"),
    //회수완료
    RETRIEVE_COMPLETE("RTC"),
    //반품완료
    RETURN_COMPLETE("RC"),
    //출고지시
    TAKEOUT_INSTRUCT("TI"),
    //피킹
    PICKING("PIK"),
    //패킹
    PACKING("PCK"),
    //출고완료
    TAKEOUT_COMPLETE("TC"),
    //배송완료
    DELIVERY_COMPLETE("DC");

    public final String code;
}
