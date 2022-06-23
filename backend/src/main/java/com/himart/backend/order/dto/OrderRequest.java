package com.himart.backend.order.dto;

import com.himart.backend.order.code.OrderType;
import com.himart.backend.order.code.SystemType;
import com.himart.backend.payment.dto.PayInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class OrderRequest {

    String orderNo;
    String systemType;
    String orderType;
    PayInfo payInfo;

}
