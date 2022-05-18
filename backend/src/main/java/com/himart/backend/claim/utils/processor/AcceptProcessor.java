package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.manipulator.ClaimDataManipulator;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class AcceptProcessor extends ClaimProcessor {

    public AcceptProcessor(ClaimValidator claimValidator, ClaimDataManipulator claimDataManipulator) {
        super(claimValidator, claimDataManipulator);
    }

    public static AcceptProcessor getAcceptProcessor(ClaimValidator claimValidator, ClaimDataManipulator claimDataManipulator){
        return new AcceptProcessor(claimValidator, claimDataManipulator);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void doValidationProcess(ClaimDto claimDto) {
        this.claimValidator.isValid(claimDto);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void doInsertMonitoringLog(ClaimDto claimDto) {
        this.claimDataManipulator.insertOrderLog(claimDto);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    void doClaimDataManipulationProcess(ClaimDto claimDto) {
        this.claimDataManipulator.insertClaimData(claimDto);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    void doUpdateMonitoringLog(ClaimDto claimDto) {
        this.claimDataManipulator.updateClaimData(claimDto);
    }

    @Override
    @Transactional
    public void doProcess(ClaimDto claimDto) {
        doValidationProcess(claimDto);
        //모니터링 : insert, updata json 형식 , 반환값은 key값
        doInsertMonitoringLog(claimDto);
        doClaimDataManipulationProcess(claimDto);
        //모니터링 : insert, updata json 형식 , 반환값은 key값
        doUpdateMonitoringLog(claimDto);
    }
}
