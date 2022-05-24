package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.ClaimBase;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import com.himart.backend.claim.utils.manipulator.ClaimDataManipulator;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@Log4j2
public class WithdrawalProcessor extends ClaimProcessor {

    private static WithdrawalProcessor withdrawalProcessor;

    public WithdrawalProcessor(ClaimValidator claimValidator, ClaimDataCreator claimDataCreator, ClaimDataManipulator claimDataManipulator) {
        super(claimValidator, claimDataCreator, claimDataManipulator);
    }

    @PostConstruct
    public void initialize() {
        withdrawalProcessor = this;
    }

    public static WithdrawalProcessor getInstance() {
        return withdrawalProcessor;
    }

    @Override
    public void doValidationProcess(ClaimDto claimDto) {
        claimValidator.isValid(claimDto);
    }

    @Override
    public void doClaimDataManipulationProcess(ClaimDto claimDto) {
        ClaimBase claimBase = claimDataCreator.getInsertClaimData(claimDto);
        claimDataManipulator.insertClaimData(claimBase);
    }

    @Transactional
    @Override
    public void doProcess(ClaimDto claimDto) {
        try {
            doValidationProcess(claimDto);
            doInsertMonitoringLog(claimDto);
            doClaimDataManipulationProcess(claimDto);
            doUpdateMonitoringLog(claimDto);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
