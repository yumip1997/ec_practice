package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.helper.IFCallHelper;
import com.himart.backend.claim.utils.manipulator.ClaimDataManipulator;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class CompleteProcessor extends ClaimProcessor {

    public CompleteProcessor(ClaimValidator claimValidator, ClaimDataManipulator claimDataManipulator) {
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
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void doIFCallProcess(ClaimDto claimDto) {
        IFCallHelper.callPaymentHelper();
        IFCallHelper.callCouponRestorHelper();
    }

    @Override
    public void doProcess(ClaimDto claimDto) {

    }
}
