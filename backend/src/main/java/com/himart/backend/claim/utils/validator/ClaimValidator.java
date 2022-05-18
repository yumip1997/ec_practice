package com.himart.backend.claim.utils.validator;

import com.himart.backend.claim.dto.ClaimDto;
import org.springframework.stereotype.Component;

@Component
public class ClaimValidator {

    public boolean isValid(ClaimDto claimDto){
        if(!isStatusValid(claimDto)){
            return false;
        }
        return true;
    }

    public boolean isStatusValid(ClaimDto claimDto){
        ClaimValidBase.valueOf(claimDto.getClaimType()).isValidStatus(claimDto);
        return true;
    }
}
