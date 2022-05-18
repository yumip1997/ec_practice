package com.himart.backend.claim.utils.core;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.processor.ClaimProcessor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

public class Exchange extends Claim {

    public Exchange(ClaimProcessor claimProcessor){
        super(claimProcessor);
    }

    public static Exchange getExchange(ClaimProcessor claimProcessor){
        return new Exchange(claimProcessor);
    }

    @Override
    public void execute(ClaimDto claimDto) {
        this.claimProcessor.doProcess(claimDto);
    }
}
