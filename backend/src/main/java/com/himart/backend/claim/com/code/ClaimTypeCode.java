package com.himart.backend.claim.com.code;

import com.himart.backend.claim.utils.core.Exchange;
import com.himart.backend.claim.utils.core.OrderCancel;
import com.himart.backend.claim.utils.core.Return;
import com.himart.backend.claim.utils.factory.ClaimProcessorType;

public enum ClaimTypeCode {
    //교환접수
    EA,
    //교환완료
    EC,
    //교환철회
    EW,
    //반품접수
    RA,
    //반품완료
    RC,
    //반품철회
    RW,
    //주문취소완료
    OC
}
