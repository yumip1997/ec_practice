package com.himart.backend.claim.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ClaimUpdateBase {

    OrderClaim orgOrderClaim;
    OrderClaim orderClaim;
    OrderBenefit orderBenefit;
}
