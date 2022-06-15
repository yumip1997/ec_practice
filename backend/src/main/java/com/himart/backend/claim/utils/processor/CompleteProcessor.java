package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import com.himart.backend.claim.utils.factory.ClaimType;
import com.himart.backend.claim.utils.helper.IFCallHelper;
import com.himart.backend.claim.utils.helper.MonitoringLogHelper;
import com.himart.backend.claim.utils.manipulator.ClaimDataManipulator;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
@Log4j2
public class CompleteProcessor extends ClaimProcessor {

    private static CompleteProcessor completeProcessor;
    private final IFCallHelper ifCallHelper;

    public CompleteProcessor(ClaimValidator claimValidator
            , ClaimDataManipulator claimDataManipulator
            , MonitoringLogHelper monitoringLogHelper
            , IFCallHelper ifCallHelper) {
        super(claimValidator, claimDataManipulator, monitoringLogHelper);
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
    public void doClaimDataManipulationProcess(ClaimDto claimDto) {


    }

    public void doIFCallProcess(ClaimDto claimDto) {
        ifCallHelper.callRestoreCouponIF();
    }

    @Transactional
    @Override
    public void doProcess(ClaimDto claimDto) {
        try{
            //TODO 채번로직 추가
            ClaimDataCreator claimDataCreator = ClaimType.valueOf(claimDto.getClaimType()).getClaimDataCreator().get();
            monitoringLogHelper.insertMonitoringLog("");
            doValidationProcess(claimDto);
            doClaimDataManipulationProcess(claimDto);
            verifyAmount(claimDto);
            doIFCallProcess(claimDto);
        }catch (Exception e){
            log.error(e.getMessage());
            monitoringLogHelper.updateMonitoringLog("");
        }
    }
}
