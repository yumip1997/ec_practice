package com.himart.backend.payment.utils.factory;

import com.himart.backend.payment.code.PaymentException;
import com.himart.backend.payment.code.PaymentType;
import com.himart.backend.payment.service.PaymentService;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PaymentServiceFactory {

    private final Map<PaymentType, PaymentService> map = new HashMap<>();

    public PaymentServiceFactory(List<PaymentService> paymentServiceList){
        paymentServiceList.forEach(paymentService -> map.put(paymentService.getType(), paymentService));
    }

    public PaymentService getPaymentService(PaymentType paymentType){
        return map.get(paymentType);
    }
}
