package com.himart.backend.claim.utils.creator;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.ClaimInsertBase;
import com.himart.backend.claim.model.ClaimUpdateBase;
import com.himart.backend.claim.model.OrderClaim;
import com.himart.backend.claim.utils.creator.code.OrderClaimBaseCode;

import java.util.List;

public interface ClaimDataCreator{

    ClaimInsertBase getInsertData(ClaimDto claimDto);
    ClaimUpdateBase getUpdateData(ClaimDto claimDto);

    default List<OrderClaim> getInertOrderClaimList(ClaimDto claimDto){
        return OrderClaimBaseCode.valueOf(claimDto.getClaimType()).getInsertOrderClaim();
    }

    default List<OrderClaim> getUpdateOrderClaimList(ClaimDto claimDto){
        return OrderClaimBaseCode.valueOf(claimDto.getClaimType()).getUpdateOrderClaim();
    }
}
