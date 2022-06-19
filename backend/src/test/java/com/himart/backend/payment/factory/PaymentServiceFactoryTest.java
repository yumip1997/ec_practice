package com.himart.backend.payment.factory;

import com.himart.backend.payment.code.PaymentType;
import com.himart.backend.payment.service.PaymentService;
import com.himart.backend.payment.service.impl.Inicis;
import com.himart.backend.payment.service.impl.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentServiceFactoryTest {

    @Autowired
    private PaymentServiceFactory paymentServiceFactory;

    @Test
    @DisplayName("이니시스 요청 일 경우 Inicis 객체를 반환한다.")
    void inicis_test(){
        PaymentType paymentType = PaymentType.INICIS;

        PaymentService paymentService = paymentServiceFactory.getPaymentService(paymentType);

        Assertions.assertThat(paymentService).isInstanceOf(Inicis.class);
    }

    @Test
    @DisplayName("포인트 요청 경우 Point 객체를 반환한다.")
    void point_test(){
        PaymentType paymentType = PaymentType.POINT;

        PaymentService paymentService = paymentServiceFactory.getPaymentService(paymentType);

        Assertions.assertThat(paymentService).isInstanceOf(Point.class);
    }
}