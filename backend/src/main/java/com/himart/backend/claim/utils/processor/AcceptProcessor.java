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
public class AcceptProcessor extends ClaimProcessor {

    private static AcceptProcessor acceptProcessor;

    public AcceptProcessor(ClaimValidator claimValidator,
                           ClaimDataManipulator claimDataManipulator,
                           MonitoringLogHelper monitoringLogHelper) {
        super(claimValidator, claimDataManipulator, monitoringLogHelper);
    }

    @PostConstruct
    private void initialize() {
        acceptProcessor = this;
    }

    public static AcceptProcessor getInstance() {
        return acceptProcessor;
    }

    @Override
    protected void doClaimDataManipulationProcess(ClaimDto claimDto) {

    }

    /*
        (클레임 채번)
        1. 모니터링 로그 생성
        2. 유효성 검증
        3. 데이터 조작(주문클레임 테이블, 주문비용테이블, 주문혜택관계 테이블, 주문혜택테이블)
        4. 금액검증
        Exception 발생시 모니터링 로그 업데이트
        */
    @Transactional
    @Override
    public void doProcess(ClaimDto claimDto) {
        try {
            ClaimDataCreator claimDataCreator = ClaimType.valueOf(claimDto.getClaimType()).getClaimDataCreator().get();
            //TODO 채번로직 추가 - claimDto.setClaimNo()?
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
