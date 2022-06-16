package com.himart.backend.claim.com.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductTypeCode {

    GENERAL("G"),
    ECOUPON("EC");

    public final String code;

}
