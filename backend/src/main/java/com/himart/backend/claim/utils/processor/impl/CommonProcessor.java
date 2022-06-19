package com.himart.backend.claim.utils.processor.impl;


import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.ClaimInsertBase;
import com.himart.backend.claim.model.ClaimUpdateBase;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import com.himart.backend.claim.utils.factory.ClaimFactory;
import com.himart.backend.claim.utils.helper.ClaimDataManipulateHelper;
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
public class CommonProcessor implements ClaimProcessor {
    
    private final MonitoringLogHelper monitoringLogHelper;
    private final ClaimDataManipulateHelper claimDataManipulateHelper;
    private static ClaimProcessor claimProcessor;

    @PostConstruct
    private void init(){
        claimProcessor = this;
    }

    public static ClaimProcessor getInstance(){
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

    /*
    1. 클레임 번호 채번
    2. 모니터링 로그 insert
    3. validation 체크
    4. 주문클레임 or 주문비용 or 주문혜택관계 or 주문혜택 테이블 insert or update
    5. 금액검증
     */
    @Override
    public void doProcess(ClaimDto claimDto) {
        Long logKey = null;
        try{
            setUpClaimNumber(claimDto);
            logKey = monitoringLogHelper.insertMonitoringLog(claimDto.toString());
            doValidationProcess(claimDto);
            doClaimDataManipulationProcess(claimDto);
            verifyAmount(claimDto);
        }catch (Exception e){
            log.error(e.getMessage());
        }finally {
            monitoringLogHelper.updateMonitoringLog("", logKey);
        }
    }
    
    private void setUpClaimNumber(ClaimDto claimDto){
        String claimNum = getClaimNumber();
        claimDto.setClaimNo(claimNum);
    }
    
    private String getClaimNumber(){
        return "";
    }

}
