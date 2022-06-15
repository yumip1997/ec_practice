package com.himart.backend.claim.utils.processor.impl;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.ClaimInsertBase;
import com.himart.backend.claim.model.ClaimUpdateBase;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import com.himart.backend.claim.utils.factory.ClaimFactory;
import com.himart.backend.claim.utils.helper.ClaimDataManipulateHelper;
import com.himart.backend.claim.utils.helper.IFCallHelper;
import com.himart.backend.claim.utils.helper.MonitoringLogHelper;
import com.himart.backend.claim.utils.processor.ClaimProcessor;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Log4j2
@RequiredArgsConstructor
public class CompleteProcessor implements ClaimProcessor {

    private final MonitoringLogHelper monitoringLogHelper;
    private final ClaimDataManipulateHelper claimDataManipulateHelper;
    private final IFCallHelper ifCallHelper;
    private static ClaimProcessor claimProcessor;

    @PostConstruct
    public void initialize() {
        claimProcessor = this;
    }

    public static ClaimProcessor getInstance() {
        return claimProcessor;
    }


    @Override
    public void doValidationProcess(ClaimDto claimDto) throws Exception {
        ClaimValidator claimValidator = ClaimFactory.findClaimValidator(claimDto.getClaimType());
        claimValidator.isValid(claimDto);
    }

    @Override
    public void doClaimDataManipulationProcess(ClaimDto claimDto) {
        ClaimDataCreator claimDataCreator = ClaimFactory.findClaimDataCreator(claimDto.getClaimType());
        insertClaim(claimDataCreator.getInsertData(claimDto));
        updateClaim(claimDataCreator.getUpdateData(claimDto));
    }

    private void insertClaim(ClaimInsertBase claimInsertBase){
        claimDataManipulateHelper.insertClaimData(claimInsertBase);
    }

    private void updateClaim(ClaimUpdateBase claimUpdateBase){
        claimDataManipulateHelper.updateClaimData(claimUpdateBase);
    }

    @Override
    public void verifyAmount(ClaimDto claimDto) throws Exception {
        ClaimValidator claimValidator = ClaimFactory.findClaimValidator(claimDto.getClaimType());
        claimValidator.verifyAmount(claimDto);
    }

    @Override
    public void doProcess(ClaimDto claimDto) {
        try{
            //TODO 채번로직 추가하기
            monitoringLogHelper.insertMonitoringLog("");
            doValidationProcess(claimDto);
            doClaimDataManipulationProcess(claimDto);
            verifyAmount(claimDto);
            ifCallHelper.callPaymentIF();
            ifCallHelper.callRestoreCouponIF();
        }catch (Exception e){
            log.error(e.getMessage());
        }finally {
            monitoringLogHelper.updateMonitoringLog("");
        }
    }
}
