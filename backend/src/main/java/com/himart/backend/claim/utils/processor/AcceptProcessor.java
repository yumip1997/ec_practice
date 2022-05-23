package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.ClaimBase;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import com.himart.backend.claim.utils.manipulator.ClaimDataManipulator;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
@Component
@Log4j2
public class AcceptProcessor extends ClaimProcessor {

    private static AcceptProcessor acceptProcessor;
    public AcceptProcessor(ClaimValidator claimValidator, ClaimDataCreator claimDataCreator, ClaimDataManipulator claimDataManipulator) {
        //부모 생성자 호출
        //bean으로 등록되어 있는 각 인스턴스들이 주입된다.
        super(claimValidator, claimDataCreator, claimDataManipulator);
    }

    @PostConstruct
    public void initialize(){
        //의존성 주입까지 완료된 후 실행됨(부모 클래스의 필드들에 의존성 주입이 완료되어있는 시점임)
        acceptProcessor = this;
    }

    public static AcceptProcessor getInstance(){
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
        try{
            doValidationProcess(claimDto);
            doInsertMonitoringLog(claimDto);
            doClaimDataManipulationProcess(claimDto);
            doUpdateMonitoringLog(claimDto);
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
