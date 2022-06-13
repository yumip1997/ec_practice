package com.himart.backend.claim.utils.manipulator;

import com.himart.backend.claim.dao.ClaimDao;
import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.OrderClaim;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class ClaimDataManipulator {

    private final ClaimDao claimDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertClaimData(OrderClaim orderClaim) {
        //TODO claimDao.insertClaim(orderClaim)
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateClaimData(OrderClaim orderClaim) {
        //TODO claimDao.updateClaim(orderClaim);
    }

    public void updateOrgOrderCancelCnt(ClaimDto claimDto){
        //TODO claimDao.updateOrgOrderCancelCnt(claimDto) (주문 row 찾아 취소 수량 +1)
    }
}

