package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.ClaimBase;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import com.himart.backend.claim.utils.helper.IFCallHelper;
import com.himart.backend.claim.utils.manipulator.ClaimDataManipulator;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@Log4j2
public class CompleteProcessor extends ClaimProcessor {

    private static CompleteProcessor completeProcessor;
    private final IFCallHelper ifCallHelper;

    public CompleteProcessor(ClaimValidator claimValidator,
                             ClaimDataCreator claimDataCreator,
                             ClaimDataManipulator claimDataManipulator,
                             IFCallHelper ifCallHelper) {
        super(claimValidator, claimDataCreator, claimDataManipulator);
        this.ifCallHelper = ifCallHelper;
    }

    @PostConstruct
    public void initialize() {
        completeProcessor = this;
    }

    public static CompleteProcessor getInstance() {
        return completeProcessor;
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

    public void doIFCallProcess(ClaimDto claimDto) {
        ifCallHelper.callCouponRestorHelper();
    }

    @Transactional
    @Override
    public void doProcess(ClaimDto claimDto) {
        try{
            doValidationProcess(claimDto);
            doInsertMonitoringLog(claimDto);
            doClaimDataManipulationProcess(claimDto);
            doIFCallProcess(claimDto);
            doUpdateMonitoringLog(claimDto);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
