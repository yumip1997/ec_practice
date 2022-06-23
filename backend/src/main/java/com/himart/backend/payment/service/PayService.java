package com.himart.backend.payment.service;

import com.himart.backend.payment.dto.ApproveRes;
import com.himart.backend.payment.dto.CancelReq;
import com.himart.backend.payment.dto.NetCancelReq;
import com.himart.backend.payment.dto.PayInfo;
import com.himart.backend.payment.utils.factory.PaymentServiceFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PayService {

    private final PaymentServiceFactory paymentServiceFactory;

    public ApproveRes approve(PayInfo payInfo){
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
