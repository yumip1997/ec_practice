package com.himart.backend.claim.utils.factory;

import com.himart.backend.claim.utils.manipulator.impl.ExchangeAcceptDataManipulator;
import com.himart.backend.claim.utils.manipulator.impl.ExchangeCompleteDataManipulator;
import com.himart.backend.claim.utils.processor.AcceptProcessor;
import com.himart.backend.claim.utils.processor.ClaimProcessor;
import com.himart.backend.claim.utils.validator.impl.ExchangeAcceptValidator;

public enum ClaimProcessorFactory {

    EA("EA", AcceptProcessor.getAcceptProcessor(new ExchangeAcceptValidator(), new ExchangeAcceptDataManipulator()));

    private final String code;
    private final ClaimProcessor claimProcessor;

    ClaimProcessorFactory(String code, ClaimProcessor claimProcessor) {
        this.code = code;
        this.claimProcessor = claimProcessor;
    }

    public ClaimProcessor getClaimProcessor(){
        return claimProcessor;
    }
}
