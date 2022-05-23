package com.himart.backend.claim.utils.validator;

import com.himart.backend.claim.dao.ClaimDao;
import com.himart.backend.claim.dto.ClaimDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClaimValidator {

    private final ClaimDao claimDao;

    public boolean isValid(ClaimDto claimDto){
        if(!isStatusValid(claimDto)){
            return false;
        }
        return true;
    }

    public boolean isStatusValid(ClaimDto claimDto){
        ClaimValidBase.valueOf(claimDto.getClaimType().name()).isValidStatus(claimDto);
        return true;
    }
}
