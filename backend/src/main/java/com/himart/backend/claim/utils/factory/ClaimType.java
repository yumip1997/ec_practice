package com.himart.backend.claim.utils.factory;

import com.himart.backend.claim.utils.creator.*;
import com.himart.backend.claim.utils.creator.impl.*;
import com.himart.backend.claim.utils.processor.AcceptProcessor;
import com.himart.backend.claim.utils.processor.ClaimProcessor;
import com.himart.backend.claim.utils.processor.CompleteProcessor;
import com.himart.backend.claim.utils.processor.WithdrawalProcessor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

@RequiredArgsConstructor
@Getter
public enum ClaimType {

    //일반주문취소완료
    GCC("GCC", CompleteProcessor::getInstance, GeneralCancelDataCreator::getInstance, Arrays.asList(), Boolean.TRUE),
    //모바일쿠폰주문취소접수
    MCA("MCA", AcceptProcessor::getInstance, EcouponCancelAcceptDataCreator::getInstance,Arrays.asList(), Boolean.TRUE),
    //모바일쿠폰주문취소완료
    MCC("MCC", CompleteProcessor::getInstance, EcouponCancelCompleteDataCreator::getInstance, Arrays.asList(), Boolean.FALSE),

    //반품접수
    RA("RA", AcceptProcessor::getInstance, ReturnAcceptDataCreator::getInstance, Arrays.asList(), Boolean.TRUE),
    //반품완료
    RC("RC", CompleteProcessor::getInstance, ReturnCompleteDataCreator::getInstance, Arrays.asList(), Boolean.FALSE),
    //반품철회
    RW("RW", WithdrawalProcessor::getInstance, ReturnWithdrawalDataCreator::getInstance, Arrays.asList(), Boolean.TRUE),

    //교환접수
    EA("EA", AcceptProcessor::getInstance, ExchangeAcceptDataCreator::getInstance, Arrays.asList(), Boolean.TRUE),
    //교환철회
    EW("EW", WithdrawalProcessor::getInstance, ExchangeWithdrawalDataCreator::getInstance, Arrays.asList(), Boolean.TRUE);

    private final String code;
    private final Supplier<ClaimProcessor> claimProcessor;
    private final Supplier<ClaimDataCreator> claimDataCreator;
    private final List<String> validStatusCodeList;
    private final Boolean claimNoFlag;

    public static ClaimProcessor findClaimProcessor(String code) throws Exception {
        return Arrays.stream(ClaimType.values())
                .filter(type -> type.getCode().equals(code))
                .findFirst()
                .map(claimType -> claimType.getClaimProcessor().get())
                .orElseThrow(() -> new Exception("클레임 타입이 올바르지 않습니다!"));
    };
}
