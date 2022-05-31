package com.himart.backend.claim.utils.factory;

import com.himart.backend.claim.utils.processor.AcceptProcessor;
import com.himart.backend.claim.utils.processor.ClaimProcessor;
import com.himart.backend.claim.utils.processor.CompleteProcessor;
import com.himart.backend.claim.utils.processor.WithdrawalProcessor;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

@RequiredArgsConstructor
public enum ClaimProcessorType {

    //의존성이 모두 주입된 인스턴스를 반환한다.

    //접수
    AC(AcceptProcessor::getInstance),
    //완료
    CP(CompleteProcessor::getInstance),
    //철회
    WD(WithdrawalProcessor::getInstance);

    private final Supplier<ClaimProcessor> supplier;

    public ClaimProcessor getClaimProcessor(){
        return supplier.get();
    }

}
