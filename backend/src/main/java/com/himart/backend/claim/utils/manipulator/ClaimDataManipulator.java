package com.himart.backend.claim.utils.manipulator;

import com.himart.backend.claim.dao.ClaimDao;
import com.himart.backend.claim.model.ClaimBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ClaimDataManipulator {

    private final ClaimDao claimDao;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertMonitoringLog(ClaimBase claimBase) {
        System.out.println("모니터링 로그 insert");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateMonitoringLog(ClaimBase claimBase) {
        System.out.println("모니터링 로그 update");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertClaimData(ClaimBase claimBase) {
        System.out.println("클레임 insert");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateClaimData(ClaimBase claimBase) {
        System.out.println("클레임 update");
    }
}

