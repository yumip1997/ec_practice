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
public class AcceptProcessor extends ClaimProcessor {

    private static AcceptProcessor acceptProcessor;

    //TODO 생성자 매개변수 리팩토링해보기
    public AcceptProcessor(ClaimValidator claimValidator,
                           ClaimDataCreator claimDataCreator,
                           ClaimDataManipulator claimDataManipulator) {
        super(claimValidator, claimDataCreator, claimDataManipulator);
    }

    @PostConstruct
    private void initialize() {
        acceptProcessor = this;
    }

    //TODO 시점 문제
    public static AcceptProcessor getInstance() {
        return acceptProcessor;
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
