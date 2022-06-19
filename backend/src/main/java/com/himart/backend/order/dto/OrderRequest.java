package com.himart.backend.order.dto;

import com.himart.backend.order.code.OrderType;
import com.himart.backend.order.code.SystemType;
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

}
