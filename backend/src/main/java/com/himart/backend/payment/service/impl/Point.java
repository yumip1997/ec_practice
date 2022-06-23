package com.himart.backend.payment.service.impl;

import com.himart.backend.payment.code.PaymentType;
import com.himart.backend.payment.dto.ApproveRes;
import com.himart.backend.payment.dto.NetCancelReq;
import com.himart.backend.payment.dto.OriginOrder;
import com.himart.backend.payment.dto.PayInfo;
import com.himart.backend.payment.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class Point implements PaymentService {


    @Override
    public ApproveRes approvePay(PayInfo payInfo) {
        log.info("포인트 승인 요청 로직을 진행한다.");
        return null;
    }

    @Override
    public void cancelPay(OriginOrder originOrder) {
        log.info("포인트 결제취소 로직을 진행한다.");
    }

    @Override
    public void netCancel(NetCancelReq netCancelReq) {
        log.info("포인트 망취소 로직을 진행한다.");
    }

    @Override
    public PaymentType getType() {
        return PaymentType.POINT;
    }
}
