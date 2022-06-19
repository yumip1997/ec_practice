package com.himart.backend.claim.utils.creator.impl;

import com.himart.backend.claim.dao.ClaimDao;
import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.ClaimInsertBase;
import com.himart.backend.claim.model.ClaimUpdateBase;
import com.himart.backend.claim.model.OrderBenefitRelation;
import com.himart.backend.claim.model.OrderClaim;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import com.himart.backend.claim.utils.creator.code.OrderClaimBaseCode;
import com.himart.backend.claim.utils.factory.ClaimFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GeneralCancelDataCreator implements ClaimDataCreator {

    private static ClaimDataCreator claimDataCreator;
    private final ClaimDao claimDao;

    @PostConstruct
    void init(){
        claimDataCreator = this;
    }

    public static ClaimDataCreator getInstance(){
        return claimDataCreator;
    }

    @Override
    public ClaimInsertBase getInsertData(ClaimDto claimDto) {
        ClaimInsertBase claimInsertBase = ClaimInsertBase.builder().build();

        List<OrderClaim> orderClaimList = getOrderClaimList(claimDto);
        claimInsertBase.setOrderClaimList(orderClaimList);

        return claimInsertBase;
    }

    @Override
    public ClaimUpdateBase getUpdateData(ClaimDto claimDto) {
        return null;
    }

    private List<OrderClaim> getOrderClaimList(ClaimDto claimDto){
        return OrderClaimBaseCode.valueOf(claimDto.getClaimType()).getInsertOrderClaim();
    }

    private List<OrderClaim> getUpdateClaimList(ClaimDto claimDto){
        return OrderClaimBaseCode.valueOf(claimDto.getClaimType()).getUpdateOrderClaim();
    }
}
