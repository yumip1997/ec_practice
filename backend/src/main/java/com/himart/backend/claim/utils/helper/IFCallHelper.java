package com.himart.backend.claim.utils.helper;

import org.springframework.stereotype.Component;

@Component
public class IFCallHelper {

    public void callCouponRestorHelper(){
        System.out.println("쿠폰 복원 API 호출");
    }

    public void callPaymentHelper(){
        System.out.println("결제 IF 호출");
    }

}
