package com.himart.backend.claim.utils.validator;

import com.himart.backend.claim.dto.ClaimDto;

public interface ClaimValidator {

    void isValid(ClaimDto claimDto) throws Exception;
    void verifyAmount(ClaimDto claimDto) throws Exception;
}

