package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;

public interface ClaimProcessor {

    void doValidationProcess(ClaimDto claimDto);
    void doInsertMonitoringLog(ClaimDto claimDto);
    void doClaimDataManipulationProcess(ClaimDto claimDto);
    void doUpdateMonitoringLog(ClaimDto claimDto);
    void doProcess(ClaimDto claimDto);
}
