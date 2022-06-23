package com.himart.backend.order.utils.after.impl;

import com.himart.backend.order.code.SystemType;
import com.himart.backend.order.dto.OrderDto;
import com.himart.backend.order.dto.OrderRequest;
import com.himart.backend.order.utils.after.AfterStrategy;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class FOAfterStrategy implements AfterStrategy {

    @Override
    public void call(OrderRequest orderRequest, OrderDto orderDto) {
        log.info("FO 주문 후처리");
    }

    @Override
    public SystemType getType() {
        return SystemType.FO;
    }
}
