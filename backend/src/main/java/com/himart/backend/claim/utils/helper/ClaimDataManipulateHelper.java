package com.himart.backend.claim.utils.helper;

import com.himart.backend.claim.dao.ClaimDao;
import com.himart.backend.claim.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ClaimDataManipulateHelper {

    private final ClaimDao claimDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public void insertClaimData(ClaimInsertBase claimInsertBase){
        insertOrderClaim(claimInsertBase.getOrderClaimList());
        insertOrderCost(claimInsertBase.getOrderCostList());
        insertOrderBenefitRelation(claimInsertBase.getOrderBenefitRelation());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateClaimData(ClaimUpdateBase claimUpdateBase){
        updateOrderClaim(claimUpdateBase.getOrderClaim());
        updateOrgOrderCnt(claimUpdateBase.getOrderClaim());
        updateOrderBenefit(claimUpdateBase.getOrderBenefit());
    }

    private void insertOrderClaim(List<OrderClaim> orderClaimList){
        if(CollectionUtils.isEmpty(orderClaimList)) return;

        claimDao.insertOrderClaim(orderClaimList);
    }

    private void insertOrderCost(List<OrderCost> orderCostList){
        if(CollectionUtils.isEmpty(orderCostList)) return;

        claimDao.insertOrderCost(orderCostList);
    }

    private void insertOrderBenefitRelation(OrderBenefitRelation orderBenefitRelation){
        if(ObjectUtils.isEmpty(orderBenefitRelation)) return;

        claimDao.insertOrderBenefitRelation(orderBenefitRelation);
    }

    private void updateOrderClaim(OrderClaim orderClaim){
        if(ObjectUtils.isEmpty(orderClaim)) return;

        claimDao.updateOrderClaim(orderClaim);
    }

    private void updateOrgOrderCnt(OrderClaim orderClaim){
        if(ObjectUtils.isEmpty(orderClaim)) return;

        claimDao.updateOrgOrderCnt(orderClaim);
    }

    private void updateOrderBenefit(OrderBenefit orderBenefit){
        if(ObjectUtils.isEmpty(orderBenefit)) return;

        claimDao.updateOrderBenefit(orderBenefit);
    }
}
