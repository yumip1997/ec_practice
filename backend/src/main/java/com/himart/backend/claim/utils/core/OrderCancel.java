package com.himart.backend.claim.utils.core;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.processor.ClaimProcessor;
import org.springframework.core.annotation.Order;

public class OrderCancel extends Claim{

    public OrderCancel(ClaimProcessor claimProcessor){
        super(claimProcessor);
    }

    public static OrderCancel getInstance(ClaimProcessor claimProcessor){
        return new OrderCancel(claimProcessor);
    }


    @Override
    public void execute(ClaimDto claimDto) {
        this.claimProcessor.doProcess(claimDto);
    }
}
