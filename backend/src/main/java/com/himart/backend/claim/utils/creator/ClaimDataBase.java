package com.himart.backend.claim.utils.creator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ClaimDataBase {

    EA("E", "D", "EA"),
    EC("E", "R", "EC");

    private final String claimCode;
    private final String deliveryCode;
    private final String orderStateCode;

}
