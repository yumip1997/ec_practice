package com.himart.backend.payment.service.impl;

import com.himart.backend.payment.dto.ApproveRes;
import com.himart.backend.payment.dto.NetCancelReq;
import com.himart.backend.payment.dto.OriginOrder;
import com.himart.backend.payment.dto.PayInfo;
import com.himart.backend.payment.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class Point implements PaymentService {
    @Override
    public void validateAuth(PayInfo payInfo) {

    }

    @Override
    public ApproveRes approvePay(PayInfo payInfo) {
        return null;
    }

    @Override
    public void cancelPay(OriginOrder originOrder) {

    }

    @Override
    public void netCancel(NetCancelReq netCancelReq) {

    }
}
