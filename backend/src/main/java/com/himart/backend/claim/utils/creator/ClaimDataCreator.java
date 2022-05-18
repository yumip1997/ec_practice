package com.himart.backend.claim.utils.creator;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.ClaimBase;
import org.springframework.stereotype.Component;

@Component
public class ClaimDataCreator {

    public ClaimBase getInsertClaimData(ClaimDto claimDto){

        ClaimDataBase claimDataBase = ClaimDataBase.valueOf(claimDto.getClaimType());

        return ClaimBase.builder()
                .claimCode(claimDataBase.getClaimCode())
                .deliveryCode(claimDataBase.getDeliveryCode())
                .orderStateCode(claimDataBase.getOrderStateCode())
                .build();

    }

}
