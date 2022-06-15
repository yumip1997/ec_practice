package com.himart.backend.claim.utils.creator.impl;

import com.himart.backend.claim.dao.ClaimDao;
import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.ClaimInsertBase;
import com.himart.backend.claim.model.ClaimUpdateBase;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class ReturnWithdrawalDataCreator implements ClaimDataCreator {

    private static ClaimDataCreator claimDataCreator;
    private final ClaimDao claimDao;

    @PostConstruct
    void init(){
        claimDataCreator = this;
    }

    public static ClaimDataCreator getInstance(){
        return claimDataCreator;
    }

    @Override
    public ClaimInsertBase getInsertData(ClaimDto claimDto) {
        return null;
    }

    @Override
    public ClaimUpdateBase getUpdateData(ClaimDto claimDto) {
        return null;
    }
}
