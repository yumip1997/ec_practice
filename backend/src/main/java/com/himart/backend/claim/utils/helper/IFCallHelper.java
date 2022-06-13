package com.himart.backend.claim.utils.helper;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class IFCallHelper {
    
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void callRestoreCouponIF(){
        System.out.println("쿠폰 복원 API 호출");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void callPaymentIF(){
        System.out.println("결제 IF 호출");
    }

}
