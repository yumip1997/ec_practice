package com.himart.backend.payment.service;

import com.himart.backend.payment.code.PaymentType;
import com.himart.backend.payment.dto.CancelReq;
import com.himart.backend.payment.dto.NetCancelReq;
import com.himart.backend.payment.dto.PayInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PayServiceTest {

    @Autowired
    private PayService payService;

    @Test
    @DisplayName("이니시스 승인")
    void test_inicis_approve(){
        PayInfo payInfo = PayInfo.builder().paymentType(PaymentType.INICIS).build();
        payService.approve(payInfo);
    }

    @Test
    @DisplayName("이니시스 결제취소")
    void test_inicis_canel(){
        CancelReq cancelReq = CancelReq.builder().paymentType(PaymentType.INICIS).build();
        payService.cancel(cancelReq);
    }

    @Test
    @DisplayName("이니시스 망취소")
    void test_inicis_netcancel(){
        NetCancelReq netCancelReq = NetCancelReq.builder().paymentType(PaymentType.INICIS).build();
        payService.netCancel(netCancelReq);
    }

    @Test
    @DisplayName("포인트 승인")
    void test_point_approve(){
        PayInfo payInfo = PayInfo.builder().paymentType(PaymentType.POINT).build();
        payService.approve(payInfo);
    }

    @Test
    @DisplayName("포인트 결제취소")
    void test_point_canel(){
        CancelReq cancelReq = CancelReq.builder().paymentType(PaymentType.POINT).build();
        payService.cancel(cancelReq);
    }

    @Test
    @DisplayName("포인트 망취소")
    void test_point_netcancel(){
        NetCancelReq netCancelReq = NetCancelReq.builder().paymentType(PaymentType.POINT).build();
        payService.netCancel(netCancelReq);
    }
}