package com.himart.backend.claim.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ClaimInsertBase {

    List<OrderClaim> orderClaimList;

    List<OrderCost> orderCostList;

    OrderBenefitRelation orderBenefitRelation;


}
