package com.himart.backend.claim.utils.factory;

import com.himart.backend.claim.utils.core.Claim;
import com.himart.backend.claim.utils.core.Exchange;
import com.himart.backend.claim.utils.manipulator.impl.ExchangeAcceptDataManipulator;
import com.himart.backend.claim.utils.processor.AcceptProcessor;
import com.himart.backend.claim.utils.processor.CompleteProcessor;
import com.himart.backend.claim.utils.validator.impl.ExchangeAcceptValidator;

public enum ClaimType {

    //교환접수
    EA("EA"){
        @Override
        Claim create() {
            return Exchange.getExchange(ClaimProcessorFactory.EA.getClaimProcessor());
        }
    };
    //교환완료

    //교환철회
    
    //반품접수
    //반품완료
    //반품철회

    private final String type;

    ClaimType(String type){
        this.type = type;
    }

    abstract Claim create();
}
