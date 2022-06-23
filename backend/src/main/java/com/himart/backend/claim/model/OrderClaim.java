package com.himart.backend.claim.model;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.define.creator.OrderClaimBaseCode;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class OrderClaim {

    //주문번호
    private String orderNo;
    //상품순번
    private long prdSnl;
    //처리순번
    //상품번호
    private String prdNo;
    //단품번호
    //주문클레임유형코드
    private String claimCode;
    //배송회수구분코드드
    private String deliveryCode;
    //주문수량
    private int orderCnt;
    //취소수량
    private int cancelCnt;
    //주문상태코드
    private String orderStateCode;

}
