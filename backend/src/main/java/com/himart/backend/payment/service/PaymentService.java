package com.himart.backend.payment.service;

import com.himart.backend.com.utils.FactoryTemplate;
import com.himart.backend.payment.code.PaymentType;
import com.himart.backend.payment.dto.ApproveRes;
import com.himart.backend.payment.dto.NetCancelReq;
import com.himart.backend.payment.dto.OriginOrder;
import com.himart.backend.payment.dto.PayInfo;

public interface PaymentService extends FactoryTemplate<PaymentType> {

    ApproveRes approvePay(PayInfo payInfo);
    void cancelPay(OriginOrder originOrder);
    void netCancel(NetCancelReq netCancelReq);

}
