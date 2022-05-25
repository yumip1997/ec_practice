package com.himart.backend.claim.utils.creator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ClaimDataBase {

    EA("E", "D", "EA"),
    EC("E", "R", "EC");

    @Getter
    private final String claimCode;
    @Getter
    private final String deliveryCode;
    @Getter
    private final String orderStateCode;

}
