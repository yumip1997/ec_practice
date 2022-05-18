package com.himart.backend.claim.utils.creator;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ClaimDataBase {

    EA("E", "D", "EA");

    private final String claimCode;
    private final String deliveryCode;
    private final String orderStateCode;

    public String getClaimCode(){
        return claimCode;
    }

    public String getDeliveryCode(){
        return deliveryCode;
    }

    public String getOrderStateCode(){
        return orderStateCode;
    }
}
