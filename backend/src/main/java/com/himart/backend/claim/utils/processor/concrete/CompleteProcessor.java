package com.himart.backend.claim.utils.processor.concrete;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.dto.LogDto;
import com.himart.backend.claim.model.ClaimInsertBase;
import com.himart.backend.claim.model.ClaimUpdateBase;
import com.himart.backend.claim.code.ClaimProcessorType;
import com.himart.backend.claim.utils.factory.ClaimValidatorFactory;
import com.himart.backend.claim.utils.helper.ClaimDataManipulateHelper;
import com.himart.backend.claim.utils.helper.IFCallHelper;
import com.himart.backend.claim.utils.helper.MonitoringLogHelper;
import com.himart.backend.claim.utils.processor.ClaimProcessor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CompleteProcessor extends ClaimProcessor {

    private final IFCallHelper ifCallHelper;

    public CompleteProcessor(ClaimValidatorFactory claimValidatorFactory,
                             MonitoringLogHelper monitoringLogHelper,
                             ClaimDataManipulateHelper claimDataManipulateHelper,
                             IFCallHelper ifCallHelper) {
        super(claimValidatorFactory, monitoringLogHelper, claimDataManipulateHelper);
        this.ifCallHelper = ifCallHelper;
    }

    @Override
    public void doProcess(ClaimDto claimDto) {
        log.info("완료 프로세스를 진행한다.");

        Long logKey = null;
        LogDto<ClaimInsertBase, ClaimUpdateBase> logDto = LogDto.<ClaimInsertBase, ClaimUpdateBase>builder().build();

        try {
            //클레임 채번
            setUpClaimNum(claimDto);

            //모니터링 로그 insert
            logKey = monitoringLogHelper.insertMonitoringLog(claimDto.toString());

            //validation check
            doValidationProcess(claimDto);

            //데이터 생성 후 조작
            logDto = doClaimDataManipulationProcess(claimDto);

            //금액검증
            verifyAmount(claimDto);

            //결제인터페이스호출
            ifCallHelper.callPaymentIF();

            //쿠폰복원인터페이스 호출
            ifCallHelper.callRestoreCouponIF();
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            monitoringLogHelper.updateMonitoringLog(logKey,  logDto.toString());
        }
    }

    @Override
    public ClaimProcessorType getType() {
        return ClaimProcessorType.COMPLETE;
    }
}
