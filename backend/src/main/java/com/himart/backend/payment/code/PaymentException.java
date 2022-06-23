package com.himart.backend.payment.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PaymentException {

    INVALID_PAYMENTTYPE("결제 유형이 올바르지 않습니다!");

    public final String MSG;
}
