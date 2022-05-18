package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.core.Claim;
import com.himart.backend.claim.utils.manipulator.ClaimDataManipulator;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;

@RequiredArgsConstructor
abstract public class ClaimProcessor {

    protected final ClaimValidator claimValidator;
    protected final ClaimDataManipulator claimDataManipulator;
    void doIFCallProcess(ClaimDto claimDto){};
    abstract void doValidationProcess(ClaimDto claimDto);
    abstract void doInsertMonitoringLog(ClaimDto claimDto);
    abstract void doClaimDataManipulationProcess(ClaimDto claimDto);
    abstract void doUpdateMonitoringLog(ClaimDto claimDto);
    abstract public void doProcess(ClaimDto claimDto);
}
