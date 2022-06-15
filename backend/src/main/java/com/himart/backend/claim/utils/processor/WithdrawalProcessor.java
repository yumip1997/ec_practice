package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import com.himart.backend.claim.utils.factory.ClaimType;
import com.himart.backend.claim.utils.helper.MonitoringLogHelper;
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

    public WithdrawalProcessor(ClaimValidator claimValidator,
                               ClaimDataManipulator claimDataManipulator,
                               MonitoringLogHelper monitoringLogHelper) {
        super(claimValidator,  claimDataManipulator, monitoringLogHelper);
    }

    @PostConstruct
    public void initialize() {
        withdrawalProcessor = this;
    }

    public static WithdrawalProcessor getInstance() {
        return withdrawalProcessor;
    }

    @Override
    public void doClaimDataManipulationProcess(ClaimDto claimDto) {

    }

    @Transactional
    @Override
    public void doProcess(ClaimDto claimDto) {
        try {
            ClaimDataCreator claimDataCreator = ClaimType.valueOf(claimDto.getClaimType()).getClaimDataCreator().get();
            //TODO 채번로직 추가
            monitoringLogHelper.insertMonitoringLog("");
            doValidationProcess(claimDto);
            doClaimDataManipulationProcess(claimDto);
            verifyAmount(claimDto);
        } catch (Exception e) {
            log.error(e.getMessage());
            monitoringLogHelper.updateMonitoringLog("");
        }
    }
}
