package com.himart.backend.payment.dto;

import com.himart.backend.payment.code.PaymentType;
import lombok.Getter;

@Getter
public class NetCancelReq {

    PaymentType paymentType;
}
