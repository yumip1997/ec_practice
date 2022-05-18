package com.himart.backend.claim.utils.core;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.processor.ClaimProcessor;

public class Exchange extends Claim {

    public Exchange(ClaimProcessor claimProcessor){
        super(claimProcessor);
    }

    public static Exchange getInstance(ClaimProcessor claimProcessor){
        return new Exchange(claimProcessor);
    }

    @Override
    public void execute(ClaimDto claimDto) {
        this.claimProcessor.doProcess(claimDto);
    }
}
