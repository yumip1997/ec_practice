package com.himart.backend.claim.utils.creator;

import com.himart.backend.claim.dao.ClaimDao;
import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.ClaimBase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClaimDataCreator {

    private final ClaimDao claimDao;

    public ClaimBase getInsertClaimData(ClaimDto claimDto){

        ClaimDataBase claimDataBase = ClaimDataBase.valueOf(claimDto.getClaimType().name());

        return ClaimBase.builder()
                .claimCode(claimDataBase.getClaimCode())
                .deliveryCode(claimDataBase.getDeliveryCode())
                .orderStateCode(claimDataBase.getOrderStateCode())
                .build();

    }

}
