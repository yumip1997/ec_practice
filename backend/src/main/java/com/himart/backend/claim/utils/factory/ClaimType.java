package com.himart.backend.claim.utils.factory;

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
    GCC("GCC", CompleteProcessor.getInstance(), Arrays.asList(), Boolean.TRUE),
    //모바일쿠폰주문취소접수
    MCA("MCA", AcceptProcessor.getInstance(), Arrays.asList(), Boolean.TRUE),
    //모바일쿠폰주문취소완료
    MCC("MCC", CompleteProcessor.getInstance(), Arrays.asList(), Boolean.FALSE),

    //반품접수
    RA("RA", AcceptProcessor.getInstance(), Arrays.asList(), Boolean.TRUE),
    //반품완료
    RC("RC", CompleteProcessor.getInstance(), Arrays.asList(), Boolean.FALSE),
    //반품철회
    RW("RW", WithdrawalProcessor.getInstance(), Arrays.asList(), Boolean.TRUE),

    //교환접수
    EA("EA", AcceptProcessor.getInstance(), Arrays.asList(), Boolean.TRUE),
    //교환철회
    EW("EW", WithdrawalProcessor.getInstance(), Arrays.asList(), Boolean.TRUE);

    private final String code;
    private final ClaimProcessor claimProcessor;
    private final List<String> validStatusCodeList;
    private final Boolean claimNoFlag;

    public static ClaimProcessor findClaimProcessor(String code) throws Exception {
        return Arrays.stream(ClaimType.values())
                .filter(type -> type.getCode().equals(code))
                .findFirst()
                .map(ClaimType::getClaimProcessor)
                .orElseThrow(() -> new Exception("클레임 타입이 올바르지 않습니다!"));
    };
}
