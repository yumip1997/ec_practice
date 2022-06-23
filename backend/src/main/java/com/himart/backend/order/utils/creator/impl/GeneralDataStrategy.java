package com.himart.backend.order.utils.creator.impl;

import com.himart.backend.order.code.OrderType;
import com.himart.backend.order.dto.OrderDto;
import com.himart.backend.order.dto.OrderProductView;
import com.himart.backend.order.dto.OrderRequest;
import com.himart.backend.order.utils.creator.DataStrategy;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class GeneralDataStrategy implements DataStrategy {

    @Override
    public OrderDto create(OrderRequest orderRequest, OrderProductView orderProductView) {
        log.info("일반상품 주문 데이터를 생성한다.");
        return null;
    }

    @Override
    public OrderType getType() {
        return OrderType.GENERAL;
    }
}
