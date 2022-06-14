package com.himart.backend.claim.model;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ClaimInsertBase {

    List<OrderClaim> orderClaimList;

    List<OrderCost> orderCostList;

    OrderBenefitRelation orderBenefitRelation;


}
