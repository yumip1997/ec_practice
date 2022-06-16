package com.himart.backend.order.service;

import com.himart.backend.order.dao.OrderDao;
import com.himart.backend.order.dto.OrderRequest;
import com.himart.backend.order.utils.after.AfterStrategy;
import com.himart.backend.order.utils.context.OrderContext;
import com.himart.backend.order.utils.creator.DataStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderHistoryService orderHistoryService;
    private final PaymentService paymentService;
    private final OrderDao orderDao;

    public void order(OrderRequest orderRequest){
        DataStrategy dataStrategy = getDataStrategy(orderRequest);
        AfterStrategy afterStrategy = getAfterStrategy(orderRequest);

        OrderContext orderContext = new OrderContext(orderHistoryService, paymentService, orderDao);
        orderContext.execute(dataStrategy, afterStrategy, orderRequest);
    }

    private DataStrategy getDataStrategy(OrderRequest orderRequest){
        return null;
    }

    private AfterStrategy getAfterStrategy(OrderRequest orderRequest){
        return null;
    }


}
