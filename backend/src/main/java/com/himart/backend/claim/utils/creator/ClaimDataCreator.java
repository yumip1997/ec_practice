package com.himart.backend.claim.utils.creator;

import com.himart.backend.claim.dao.ClaimDao;
import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.OrderClaim;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClaimDataCreator {

    private final ClaimDao claimDao;
    
    public OrderClaim getInsertOrderClaimData(ClaimDto claimDto){
        
        //TODO OrderClaim orderClaim = claimDao.selectClaim(claimDto);

        OrderClaim orderClaimSample = OrderClaim.builder().build();
        setInsertOrderClaimData(orderClaimSample, claimDto.getClaimType());

        return OrderClaim.builder().build();

    }

    private void setInsertOrderClaimData(OrderClaim orderClaim, String claimType){
        ClaimDataBase claimDataBase = ClaimDataBase.valueOf(claimType);
        orderClaim.setClaimCode(claimDataBase.getClaimCode());
        orderClaim.setDeliveryCode(claimDataBase.getDeliveryCode());
        orderClaim.setOrderStateCode(claimDataBase.getOrderStateCode());
    }
    
    public OrderClaim getUpdateOrderClaimData(ClaimDto claimDto){

        ClaimDataBase claimDataBase = ClaimDataBase.valueOf(claimDto.getClaimType());

        return OrderClaim.builder()
                .orderStateCode(claimDataBase.getOrderStateCode())
                .build();

    }



}
