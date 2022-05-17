package com.himart.backend.claim.utils.validator.impl;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.validator.abstract_.AcceptValidator;
import org.springframework.stereotype.Component;

@Component
public class ExchangeAcceptValidator extends AcceptValidator {

    @Override
    public boolean isValid(ClaimDto claimDto) {
        System.out.println("교환접수 validator");
        return false;
    }

    public boolean isValidStatus(ClaimDto claimDto) {
        return false;
    }
}
