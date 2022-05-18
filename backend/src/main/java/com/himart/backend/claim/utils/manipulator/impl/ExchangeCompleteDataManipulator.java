package com.himart.backend.claim.utils.manipulator.impl;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.manipulator.abstract_.CompleteDataManipulator;

public class ExchangeCompleteDataManipulator extends CompleteDataManipulator {
    @Override
    public void insertOrderLog(ClaimDto claimDto) {
        System.out.println("주문 로그 insert");
    }

    @Override
    public void updateOrderLog(ClaimDto claimDto) {
        System.out.println("주문 로그 update");
    }

    @Override
    public void insertClaimData(ClaimDto claimDto) {
        System.out.println("주문 클레임 insert");
    }

    @Override
    public void updateClaimData(ClaimDto claimDto) {
        System.out.println("주문 클레임 update");
    }
}
