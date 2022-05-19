package com.himart.backend.claim.utils.factory;

import com.himart.backend.claim.utils.core.Claim;
import com.himart.backend.claim.utils.core.Exchange;
import com.himart.backend.claim.utils.core.OrderCancel;
import com.himart.backend.claim.utils.core.Return;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

@RequiredArgsConstructor
public enum ClaimType {
    //클레임 타입별 객체를 반환하는 함수를 가지고 있는 enum

    //교환접수
    EA(() -> (Exchange.getInstance(ClaimProcessorType.AC.getClaimProcessor()))),
    //교환완료
    EC(() -> (Exchange.getInstance(ClaimProcessorType.CP.getClaimProcessor()))),
    //교환철회
    EW(() -> (Exchange.getInstance(ClaimProcessorType.WD.getClaimProcessor()))),
    //반품접수
    RA(() ->(Return.getInstance(ClaimProcessorType.AC.getClaimProcessor()))),
    //반품완료
    RC(() ->(Return.getInstance(ClaimProcessorType.CP.getClaimProcessor()))),
    //반품철회
    RW(() ->(Return.getInstance(ClaimProcessorType.WD.getClaimProcessor()))),
    //주문취소완료
    OC(() -> (OrderCancel.getInstance(ClaimProcessorType.CP.getClaimProcessor())));

    private final Supplier<Claim> supplier;

    public Claim getClaim(){
        return supplier.get();
    }
}
