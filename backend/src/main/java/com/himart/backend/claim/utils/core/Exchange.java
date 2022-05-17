package com.himart.backend.claim.utils.core;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.processor.ClaimProcessor;

public class Exchange extends Claim {

    public Exchange(ClaimProcessor claimProcessor){
        super(claimProcessor);
    }

    @Override
    public void doProcess(ClaimDto claimDto) {
        doValidationProcess(claimDto);
        doDataCreationProcess(claimDto);
        doIFCallProcess(claimDto);
    }
}
