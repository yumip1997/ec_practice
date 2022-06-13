package com.himart.backend.claim.utils.creator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.locks.ReadWriteLock;

@RequiredArgsConstructor
@Getter
public enum ClaimDataBase {

    GCC("C", "D", "OC"),
    MCA("C", "D", "OA"),
    MCC("C", "D", "OC"),

    RA("R","R","RA"),
    RC("R","R","RC"),
    RW("R","R","RW"),

    EA("X", "D", "EA"),
    EC("XC", "R", "EC");

    private final String claimCode;
    private final String deliveryCode;
    private final String orderStateCode;

}
