package com.himart.backend.claim.utils.manipulator;

import com.himart.backend.claim.model.ClaimBase;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ClaimDataManipulator {

    //TODO Transaction 전파 되는지 확인해보기!
    //실제로는 return 타입이 void가 아님!

    //해당 메서드를 호출한 곳의 트랜잭션과 별개로 새로운 트랜잭션이 시작
    //예외가 발생되면 롤백되고 롤백이 메서드를 호출한 곳까지 전파되지 않음
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertOrderLog(ClaimBase claimBase) {
        System.out.println("모니터링 로그 insert");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateOrderLog(ClaimBase claimBase) {
        System.out.println("모니터링 로그 update");
    }

    //해당 메서드를 호출한 곳의 트랜잭션에서 시작
    //예외가 발생하면 호출한 곳에서도 롤백이 전파
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertClaimData(ClaimBase claimBase) {
        System.out.println("클레임 insert");
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateClaimData(ClaimBase claimBase) {
        System.out.println("클레임 update");
    }
}

