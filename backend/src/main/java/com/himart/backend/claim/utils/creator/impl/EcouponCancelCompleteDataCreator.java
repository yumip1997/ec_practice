package com.himart.backend.claim.utils.creator.impl;

import com.himart.backend.claim.dao.ClaimDao;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class EcouponCancelCompleteDataCreator implements ClaimDataCreator {

    private static ClaimDataCreator claimDataCreator;
    private final ClaimDao claimDao;

    @PostConstruct
    void init(){
        claimDataCreator = this;
    }

    public static ClaimDataCreator getInstance(){
        return claimDataCreator;
    }

}
