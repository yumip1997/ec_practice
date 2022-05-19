package com.himart.backend.claim.utils.validator;

import com.himart.backend.claim.dao.ClaimDao;
import com.himart.backend.claim.dto.ClaimDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class ClaimValidator {

    //TODO ClaimDao 주입 방법 생각해보기!

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
