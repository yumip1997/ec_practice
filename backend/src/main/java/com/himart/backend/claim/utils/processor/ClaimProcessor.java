package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.helper.MonitoringLogHelper;
import com.himart.backend.claim.utils.manipulator.ClaimDataManipulator;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
abstract public class ClaimProcessor {

    protected final ClaimValidator claimValidator;
    protected final ClaimDataManipulator claimDataManipulator;
    protected final MonitoringLogHelper monitoringLogHelper;

    protected void doValidationProcess(ClaimDto claimDto) throws Exception{
        claimValidator.isValidProductType(claimDto);
        claimValidator.isValidOrderdStatus(claimDto);
        claimValidator.isValidAmount(claimDto);
    }
    abstract protected void doClaimDataManipulationProcess(ClaimDto claimDto);

    protected void verifyAmount(ClaimDto claimDto) throws Exception{
        claimValidator.verifyAmount(claimDto);
    }
    abstract public void doProcess(ClaimDto claimDto);


}
