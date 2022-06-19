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
import com.himart.backend.payment.service.PayService;
import com.himart.backend.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderHistoryService orderHistoryService;
    private final OrderDao orderDao;
    private final PayService payService;

    public void order(OrderRequest orderRequest) throws Exception {
        DataStrategy dataStrategy = getDataStrategy(orderRequest);
        AfterStrategy afterStrategy = getAfterStrategy(orderRequest);

        OrderContext orderContext = new OrderContext(orderHistoryService, orderDao, payService);
        orderContext.execute(dataStrategy, afterStrategy, orderRequest);
    }

    public DataStrategy getDataStrategy(OrderRequest orderRequest) throws Exception {
        if(OrderType.GENERAL.getCode().equals(orderRequest.getOrderType())){
            return new GeneralDataStrategy();
        }else if(OrderType.ECOUPON.getCode().equals(orderRequest.getOrderType())){
            return new ECouponDataStrategy();
        }
       throw new Exception(OrderException.INVALID_ORDER_TPYE.msg);
    }

    public AfterStrategy getAfterStrategy(OrderRequest orderRequest) throws Exception {
        if(SystemType.FO.getCode().equals(orderRequest.getSystemType())){
            return new FOAfterStrategy();
        }else if(SystemType.BO.getCode().equals(orderRequest.getSystemType())){
            return new BOAfterStrategy();
        }
        throw new Exception(OrderException.INVALID_SYSTEM_TYPE.msg);
    }


}
