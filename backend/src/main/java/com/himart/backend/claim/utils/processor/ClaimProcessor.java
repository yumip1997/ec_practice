package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.ClaimBase;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import com.himart.backend.claim.utils.manipulator.ClaimDataManipulator;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
abstract public class ClaimProcessor {

    protected final ClaimValidator claimValidator;
    protected final ClaimDataCreator claimDataCreator;
    protected final ClaimDataManipulator claimDataManipulator;

    abstract protected void doValidationProcess(ClaimDto claimDto);
    protected void doInsertMonitoringLog(ClaimDto claimDto){
        ClaimBase claimBase = claimDataCreator.getInsertClaimData(claimDto);
        claimDataManipulator.insertOrderLog(claimBase);
    }

    abstract protected void doClaimDataManipulationProcess(ClaimDto claimDto);

    protected void doUpdateMonitoringLog(ClaimDto claimDto){
        ClaimBase claimBase = claimDataCreator.getUpdateClaimData(claimDto);
        claimDataManipulator.updateOrderLog(claimBase);
    }
    abstract public void doProcess(ClaimDto claimDto);
}
