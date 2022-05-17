package com.himart.backend.claim.utils.core;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.processor.ClaimProcessor;

abstract public class Claim {

    private ClaimProcessor claimProcessor;

    public Claim(ClaimProcessor claimProcessor) {
        this.claimProcessor = claimProcessor;
    }

    void doValidationProcess(ClaimDto claimDto) {
        claimProcessor.doValidationProcess(claimDto);
    }

    void doDataCreationProcess(ClaimDto claimDto) {
        claimProcessor.doDataCreationProcess(claimDto);
    }

    void doIFCallProcess(ClaimDto claimDto) {
        claimProcessor.doIFCallProcess(claimDto);
    }

    abstract public void doProcess(ClaimDto claimDto);
}
