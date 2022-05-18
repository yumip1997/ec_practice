package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.manipulator.ClaimDataManipulator;
import com.himart.backend.claim.utils.processor.ClaimProcessor;
import com.himart.backend.claim.utils.validator.ClaimValidator;

public class WithdrawalProcessor extends ClaimProcessor {
    public WithdrawalProcessor(ClaimValidator claimValidator, ClaimDataManipulator claimDataManipulator) {
        super(claimValidator, claimDataManipulator);
    }

    @Override
    void doValidationProcess(ClaimDto claimDto) {

    }

    @Override
    void doInsertMonitoringLog(ClaimDto claimDto) {

    }

    @Override
    void doClaimDataManipulationProcess(ClaimDto claimDto) {

    }

    @Override
    void doUpdateMonitoringLog(ClaimDto claimDto) {

    }

    @Override
    public void doProcess(ClaimDto claimDto) {

    }
}
