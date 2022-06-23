package com.himart.backend.payment.dto;

import com.himart.backend.payment.code.PaymentType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CancelReq {
    PaymentType paymentType;
    OriginOrder originOrder;
}
