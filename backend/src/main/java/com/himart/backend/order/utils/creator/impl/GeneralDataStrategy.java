package com.himart.backend.order.utils.creator.impl;

import com.himart.backend.order.dto.OrderDto;
import com.himart.backend.order.dto.OrderProductView;
import com.himart.backend.order.dto.OrderRequest;
import com.himart.backend.order.utils.creator.DataStrategy;

public class GeneralDataStrategy implements DataStrategy {
    @Override
    public OrderDto create(OrderRequest orderRequest, OrderProductView orderProductView) {
        //OrderModelCreator를 이용해서 데이터 생성
        return null;
    }
}