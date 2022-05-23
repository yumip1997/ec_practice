package com.himart.backend.claim.utils.validator;

import com.himart.backend.claim.dao.ClaimDao;
import com.himart.backend.claim.dto.ClaimDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClaimValidator {

    private final ClaimDao claimDao;

    public void isValid(ClaimDto claimDto){
        this.isStatusValid(claimDto);
    }

    public void isStatusValid(ClaimDto claimDto){
        boolean valid = ClaimValidBase.valueOf(claimDto.getClaimType().name()).isValidStatus(claimDto);
        if(!valid){
            throw new RuntimeException("클레임 가능 상태가 아닙니다!");
        }
    }
}
