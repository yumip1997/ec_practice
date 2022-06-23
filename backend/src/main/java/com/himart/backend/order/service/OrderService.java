package com.himart.backend.order.service;

import com.himart.backend.order.code.OrderException;
import com.himart.backend.order.code.OrderType;
import com.himart.backend.order.code.SystemType;
import com.himart.backend.order.dao.OrderDao;
import com.himart.backend.order.dto.OrderRequest;
import com.himart.backend.order.utils.after.AfterStrategy;
import com.himart.backend.order.utils.after.impl.BOAfterStrategy;
import com.himart.backend.order.utils.after.impl.FOAfterStrategy;
import com.himart.backend.order.utils.context.OrderContext;
import com.himart.backend.order.utils.creator.DataStrategy;
import com.himart.backend.order.utils.creator.impl.ECouponDataStrategy;
import com.himart.backend.order.utils.creator.impl.GeneralDataStrategy;
import com.himart.backend.order.utils.factory.AfterStrategyFactory;
import com.himart.backend.order.utils.factory.DataStrategyFactory;
import com.himart.backend.payment.service.PayService;
import com.himart.backend.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final DataStrategyFactory dataStrategyFactory;
    private final AfterStrategyFactory afterStrategyFactory;

    private final OrderHistoryService orderHistoryService;
    private final OrderDao orderDao;
    private final PayService payService;

    public void order(OrderRequest orderRequest) throws Exception {
        OrderType orderType = OrderType.findOrderType(orderRequest.getOrderType());
        DataStrategy dataStrategy = dataStrategyFactory.getDataStrategy(orderType);

        SystemType systemType = SystemType.findSystemType(orderRequest.getSystemType());
        AfterStrategy afterStrategy = afterStrategyFactory.getAfterStrategy(systemType);

        OrderContext orderContext = new OrderContext(orderHistoryService, orderDao, payService);
        orderContext.execute(dataStrategy, afterStrategy, orderRequest);
    }

}
