package com.himart.backend.payment.service;

import com.himart.backend.payment.dto.ApproveRes;
import com.himart.backend.payment.dto.CancelReq;
import com.himart.backend.payment.dto.NetCancelReq;
import com.himart.backend.payment.dto.PayInfo;
import com.himart.backend.payment.factory.PaymentServiceFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayService {

    private final PaymentServiceFactory paymentServiceFactory;


    public ApproveRes approve(PayInfo payInfo){
        //이니시스인지 포인트인지 PaymentType으로 찾음
        PaymentService paymentService = paymentServiceFactory.getPaymentService(payInfo.getPaymentType());
        return paymentService.approvePay(payInfo);
    }

    public void cancel(CancelReq cancelReq){
        PaymentService paymentService = paymentServiceFactory.getPaymentService(cancelReq.getPaymentType());
        paymentService.cancelPay(cancelReq.getOriginOrder());
    }

    public void netCancel(NetCancelReq netCancelReq){
        PaymentService paymentService = paymentServiceFactory.getPaymentService(netCancelReq.getPaymentType());
        paymentService.netCancel(netCancelReq);
    }

}
