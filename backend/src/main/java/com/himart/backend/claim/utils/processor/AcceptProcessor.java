package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.ClaimBase;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import com.himart.backend.claim.utils.manipulator.ClaimDataManipulator;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class AcceptProcessor implements ClaimProcessor {

    private final ClaimValidator claimValidator;
    private final ClaimDataCreator claimDataCreator;
    private final ClaimDataManipulator claimDataManipulator;

    public static AcceptProcessor getInstance(ClaimValidator claimValidator,
                                              ClaimDataCreator claimDataCreator,
                                              ClaimDataManipulator claimDataManipulator){
        return new AcceptProcessor(claimValidator, claimDataCreator, claimDataManipulator);
    }


    @Override
    public void doValidationProcess(ClaimDto claimDto) {
        claimValidator.isValid(claimDto);
    }

    @Override
    public void doInsertMonitoringLog(ClaimDto claimDto) {
        ClaimBase claimBase = claimDataCreator.getInsertClaimData(claimDto);
        //JSON 형태로 변환
        claimDataManipulator.insertOrderLog(claimBase);

    }

    @Override
    public void doClaimDataManipulationProcess(ClaimDto claimDto) {
        ClaimBase claimBase = claimDataCreator.getInsertClaimData(claimDto);
        claimDataManipulator.insertClaimData(claimBase);
        //주문비용, 주문혜택 등에 insert 또는 update시킬 데이터를 ClaimDataCreator를 통해 가져온 후 실행시킨다

    }

    @Override
    public void doUpdateMonitoringLog(ClaimDto claimDto) {

    }

    @Transactional
    @Override
    public void doProcess(ClaimDto claimDto) {
        doValidationProcess(claimDto);
        doInsertMonitoringLog(claimDto);
        doClaimDataManipulationProcess(claimDto);
        doUpdateMonitoringLog(claimDto);
    }
}
