package com.himart.backend.claim.utils.validator;

import com.himart.backend.claim.dto.ClaimDto;
import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;

@RequiredArgsConstructor
public enum ClaimValidBase {

    //배송완료된 상태인가?
    EA((ClaimDataBase) -> (false)),
    //교환완료
    EC((ClaimDataBase) -> (false)),
    //교환철회
    EW((ClaimDataBase) -> (false));
    //반품접수
    //반품완료
    //반품철회

    private final Predicate<ClaimDto> isValidStatus;

    public boolean isValidStatus(ClaimDto claimDto){
        return isValidStatus.test(claimDto);
    }
}
