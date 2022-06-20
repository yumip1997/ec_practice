package com.himart.backend.payment.factory;

import com.himart.backend.payment.code.PaymentType;
import com.himart.backend.payment.service.PaymentService;
import com.himart.backend.payment.service.impl.Inicis;
import com.himart.backend.payment.service.impl.Point;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PaymentServiceFactory {

    private final List<PaymentService> paymentServiceList;
    private Map<PaymentType, PaymentService> map = new HashMap<>();

    @PostConstruct
    void init(){
        paymentServiceList.forEach(paymentService -> map.put(paymentService.getType(), paymentService));
    }


    public PaymentService getPaymentService(PaymentType paymentType){
        return map.get(paymentType);
    }
}
