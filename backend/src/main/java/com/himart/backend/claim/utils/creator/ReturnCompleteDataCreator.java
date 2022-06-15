package com.himart.backend.claim.utils.creator;

import com.himart.backend.claim.dao.ClaimDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class ReturnCompleteDataCreator implements ClaimDataCreator{

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
