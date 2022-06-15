package com.himart.backend.payment.factory;

import com.himart.backend.payment.code.PaymentType;
import com.himart.backend.payment.service.PaymentService;
import com.himart.backend.payment.service.impl.Inicis;
import com.himart.backend.payment.service.impl.Point;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PaymentServiceFactory {

    private final Point point;
    private final Inicis inicis;

    private Map<PaymentType, PaymentService> map = new HashMap<>();

    @PostConstruct
    void init(){
        map.put(PaymentType.POINT, point);
        map.put(PaymentType.INICIS, inicis);
    }

    public PaymentService getPaymentService(PaymentType paymentType){
        return map.get(paymentType);
    }
}
