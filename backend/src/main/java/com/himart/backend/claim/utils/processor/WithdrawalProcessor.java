package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class WithdrawalProcessor implements ClaimProcessor {

    private static WithdrawalProcessor withdrawalProcessor;
    private final ClaimValidator claimValidator;
    private final ClaimDataCreator claimDataCreator;

    @PostConstruct
    public void initialize(){
        if(withdrawalProcessor != null) return;
        withdrawalProcessor = this;
    }

    public static WithdrawalProcessor getInstance(){
        return withdrawalProcessor;
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
