package com.himart.backend.order.utils.context;

import com.himart.backend.order.code.OrderException;
import com.himart.backend.order.dao.OrderDao;
import com.himart.backend.order.dto.OrderDto;
import com.himart.backend.order.dto.OrderProductView;
import com.himart.backend.order.dto.OrderRequest;
import com.himart.backend.order.dto.OrderValidationDto;
import com.himart.backend.order.service.OrderHistoryService;
import com.himart.backend.order.utils.after.AfterStrategy;
import com.himart.backend.order.utils.creator.DataStrategy;
import com.himart.backend.order.utils.validator.OrderValidator;
import com.himart.backend.payment.service.PayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Log4j2
public class OrderContext {

    private final OrderHistoryService orderHistoryService;
    private final OrderDao orderDao;
    private final PayService payService;

    public void execute(DataStrategy dataStrategy, AfterStrategy afterStrategy, OrderRequest orderRequest){
        //TODO OrderDao에서 가져오기
        OrderProductView productView = new OrderProductView();

        Long logKey = null;

        try{
            //주문 모니터링 로그 생성
            logKey = orderHistoryService.insertOrderHistory(orderRequest);

            //파라미터 유혀성 검증
            validate(orderRequest);

            //주문데이터생성
            OrderDto orderDto = dataStrategy.create(orderRequest, productView);

            //결제호출
            payService.approve(orderRequest.getPayInfo());

            //주문데이터등록
            insertOrderData(orderDto);

            //TODO 금액검증

            afterStrategy.call(orderRequest, orderDto);
        }catch (Exception e){
            log.error(e.getMessage());
        }

    }

    private void validate(OrderRequest orderRequest) throws Exception {
        log.info("파라미터 유효성 체크를 한다.");
        OrderValidator orderValidator = OrderValidator.findOrderValidatory(orderRequest);
        boolean isValid = orderValidator.test(new OrderValidationDto());

        if(isValid) return;
        throw new Exception(OrderException.INVALID_ORDER.msg);
    }

    private void insertOrderData(OrderDto orderDto){
        //TODO orderDao.insertOrderData(orderDto);
    }

}
