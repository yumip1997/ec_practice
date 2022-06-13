package com.himart.backend.claim.utils.factory;

import com.himart.backend.claim.utils.core.Claim;
import com.himart.backend.claim.utils.core.Exchange;
import com.himart.backend.claim.utils.core.OrderCancel;
import com.himart.backend.claim.utils.core.Return;
import com.himart.backend.claim.utils.processor.AcceptProcessor;
import com.himart.backend.claim.utils.processor.ClaimProcessor;
import com.himart.backend.claim.utils.processor.CompleteProcessor;
import com.himart.backend.claim.utils.processor.WithdrawalProcessor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Getter
public enum ClaimType {

    //일반주문취소완료
    GCC("GCC", OrderCancel.getInstance(CompleteProcessor.getInstance()), Arrays.asList(), Boolean.TRUE),
    //모바일쿠폰주문취소접수
    MCA("MCA", OrderCancel.getInstance(AcceptProcessor.getInstance()), Arrays.asList(), Boolean.TRUE),
    //모바일쿠폰주문취소완료
    MCC("MCC", OrderCancel.getInstance(CompleteProcessor.getInstance()), Arrays.asList(), Boolean.FALSE),

    //반품접수
    RA("RA", Return.getInstance(AcceptProcessor.getInstance()), Arrays.asList(), Boolean.TRUE),
    //반품완료
    RC("RC", Return.getInstance(CompleteProcessor.getInstance()), Arrays.asList(), Boolean.FALSE),
    //반품철회
    RW("RW", Return.getInstance(WithdrawalProcessor.getInstance()), Arrays.asList(), Boolean.TRUE),

    //교환접수
    EA("EA", Exchange.getInstance(AcceptProcessor.getInstance()), Arrays.asList(), Boolean.TRUE),
    //교환철회
    EW("EW", Exchange.getInstance(WithdrawalProcessor.getInstance()), Arrays.asList(), Boolean.TRUE);

    private final String code;
    private final Claim claim;
    private final List<String> validStatusCodeList;
    private final Boolean claimNoFlag;

    public static ClaimType findClaimType(String code) throws Exception {
        return Arrays.stream(ClaimType.values())
                .filter(type -> type.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new Exception("클레임 타입이 올바르지 않습니다!"));
    };
}
