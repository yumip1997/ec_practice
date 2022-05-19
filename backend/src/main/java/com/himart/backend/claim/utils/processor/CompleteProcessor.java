package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.ClaimBase;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import com.himart.backend.claim.utils.helper.IFCallHelper;
import com.himart.backend.claim.utils.manipulator.ClaimDataManipulator;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class CompleteProcessor implements ClaimProcessor {

    private final ClaimValidator claimValidator;
    private final ClaimDataCreator claimDataCreator;
    private final ClaimDataManipulator claimDataManipulator;
    private final IFCallHelper ifCallHelper;

    public static CompleteProcessor getInstance(ClaimValidator claimValidator,
                                                ClaimDataCreator claimDataCreator,
                                                ClaimDataManipulator claimDataManipulator,
                                                IFCallHelper ifCallHelper) {
        return new CompleteProcessor(claimValidator, claimDataCreator, claimDataManipulator, ifCallHelper);
    }
    @Override
    public void doValidationProcess(ClaimDto claimDto) {
        claimValidator.isValid(claimDto);
    }

    @Override
    public void doInsertMonitoringLog(ClaimDto claimDto) {
        ClaimBase claimBase = claimDataCreator.getInsertClaimData(claimDto);
        //JSON 형태로 변환
        claimDataManipulator.insertClaimData(claimBase);

    }

    @Override
    public void doClaimDataManipulationProcess(ClaimDto claimDto) {
        ClaimBase claimBase = claimDataCreator.getInsertClaimData(claimDto);
        claimDataManipulator.insertClaimData(claimBase);
        //... 실행

    }

    @Override
    public void doUpdateMonitoringLog(ClaimDto claimDto) {

    }

    public void doIFCallProcess(ClaimDto claimDto){
        ifCallHelper.callCouponRestorHelper();
        ifCallHelper.callCouponRestorHelper();
    }

    @Transactional
    @Override
    public void doProcess(ClaimDto claimDto) {
        doValidationProcess(claimDto);
        doInsertMonitoringLog(claimDto);
        doClaimDataManipulationProcess(claimDto);
        doIFCallProcess(claimDto);
        doUpdateMonitoringLog(claimDto);
    }
}
