package com.himart.backend.claim.utils.factory;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.core.Claim;
import com.himart.backend.claim.utils.core.Exchange;
import com.himart.backend.claim.utils.creator.impl.ExchangeAcceptDataCreator;
import com.himart.backend.claim.utils.processor.impl.ExchangeAcceptProcessor;
import com.himart.backend.claim.utils.validator.impl.ExchangeAcceptValidator;

public enum ClaimType {

    //교환접수
    //TODO new 연산자가 필요할까?
    EA("EA"){
        @Override
        Claim create() {
            return new Exchange(new ExchangeAcceptProcessor(new ExchangeAcceptValidator(), new ExchangeAcceptDataCreator()));
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
