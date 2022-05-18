package com.himart.backend.claim.utils.manipulator;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.ClaimBase;
import com.himart.backend.claim.utils.core.Claim;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class ClaimDataManipulator {

    //실제로는 return 타입이 void가 아님!

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertOrderLog(ClaimBase claimBase) {
        System.out.println("로그 insert");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateOrderLog(ClaimBase claimBase) {
        System.out.println("로그 update");
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
