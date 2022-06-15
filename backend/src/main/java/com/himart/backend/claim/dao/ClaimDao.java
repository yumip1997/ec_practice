package com.himart.backend.claim.dao;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.OrderBenefit;
import com.himart.backend.claim.model.OrderBenefitRelation;
import com.himart.backend.claim.model.OrderClaim;
import com.himart.backend.claim.model.OrderCost;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClaimDao {

    OrderClaim selectClaim(ClaimDto claimDto);

    void insertOrderClaim(List<OrderClaim> orderClaimList);
    void insertOrderCost(List<OrderCost> orderCostList);
    void insertOrderBenefitRelation(OrderBenefitRelation orderBenefitRelation);

    void updateOrderClaim(OrderClaim orderClaim);
    void updateOrgOrderCnt(OrderClaim orderClaim);
    void updateOrderBenefit(OrderBenefit orderBenefit);

}
