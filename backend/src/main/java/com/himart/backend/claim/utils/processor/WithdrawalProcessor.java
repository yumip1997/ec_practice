package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class WithdrawalProcessor implements ClaimProcessor {

    private final ClaimValidator claimValidator;
    private final ClaimDataCreator claimDataCreator;

    public static WithdrawalProcessor getInstance(ClaimValidator claimValidator, ClaimDataCreator claimDataCreator){
        return new WithdrawalProcessor(claimValidator, claimDataCreator);
    }

    @Override
    public void doValidationProcess(ClaimDto claimDto) {

    }

    @Override
    public void doInsertMonitoringLog(ClaimDto claimDto) {

    }

    @Override
    public void doClaimDataManipulationProcess(ClaimDto claimDto) {

    }

    @Override
    public void doUpdateMonitoringLog(ClaimDto claimDto) {

    }

    @Override
    public void doProcess(ClaimDto claimDto) {

    }
}
