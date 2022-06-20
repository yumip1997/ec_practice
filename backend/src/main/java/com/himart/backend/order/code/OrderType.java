package com.himart.backend.order.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum OrderType{
    ECOUPON("EC"),
    GENERAL("GL");

    private final String code;
}
