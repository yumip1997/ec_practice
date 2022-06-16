package com.himart.backend.order.utils.creator;

import com.himart.backend.order.dto.OrderDto;
import com.himart.backend.order.dto.OrderProductView;
import com.himart.backend.order.dto.OrderRequest;

public interface DataStrategy {

    OrderDto create(OrderRequest orderRequest, OrderProductView orderProductView);

}
