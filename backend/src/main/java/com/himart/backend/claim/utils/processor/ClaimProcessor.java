package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;

public interface ClaimProcessor {

    void doValidationProcess(ClaimDto claimDto);
    void doDataCreationProcess(ClaimDto claimDto);
    void doIFCallProcess(ClaimDto claimDto);
}
