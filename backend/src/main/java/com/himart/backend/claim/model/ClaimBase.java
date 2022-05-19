package com.himart.backend.claim.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClaimBase {
    
    private String claimCode;
    private String deliveryCode;
    private String orderStateCode;
}
