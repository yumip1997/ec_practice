package com.himart.backend.order.code;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SystemType {
    FO("FO"),
    BO("BO");

    private final String code;
}
