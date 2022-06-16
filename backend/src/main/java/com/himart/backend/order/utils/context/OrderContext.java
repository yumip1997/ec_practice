package com.himart.backend.order.utils.context;

import com.himart.backend.order.dao.OrderDao;
import com.himart.backend.order.dto.OrderDto;
import com.himart.backend.order.dto.OrderProductView;
import com.himart.backend.order.dto.OrderRequest;
import com.himart.backend.order.service.OrderHistoryService;
import com.himart.backend.order.service.PaymentService;
import com.himart.backend.order.utils.after.AfterStrategy;
import com.himart.backend.order.utils.creator.DataStrategy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderContext {

    private final OrderHistoryService orderHistoryService;
    private final PaymentService paymentService;
    private final OrderDao orderDao;

    public void execute(DataStrategy dataStrategy, AfterStrategy afterStrategy, OrderRequest orderRequest){
        //OrderProductView?
        OrderProductView productView = new OrderProductView();
        OrderDto orderDto = dataStrategy.create(orderRequest, productView);
        insertOrderData(orderDto);
        afterStrategy.call(orderRequest, orderDto);
    }

    private void validateAmount(String orderNo){

    }

    private void insertOrderData(OrderDto  orderDto){
        orderDao.insertOrderData(orderDto);
    }

}
