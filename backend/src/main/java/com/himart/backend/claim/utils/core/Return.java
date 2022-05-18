package com.himart.backend.claim.utils.core;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.processor.ClaimProcessor;

public class Return extends Claim{

    public Return(ClaimProcessor claimProcessor){
        super(claimProcessor);
    }

    public static Return getInstance(ClaimProcessor claimProcessor){
        return new Return(claimProcessor);
    }

    @Override
    public void execute(ClaimDto claimDto) {
        this.claimProcessor.doProcess(claimDto);
    }
}
