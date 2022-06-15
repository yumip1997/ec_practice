package com.himart.backend.claim.utils.creator.code;

import com.himart.backend.claim.model.OrderClaim;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Getter
public enum OrderClaimCode {

    //일반상품주문취소완료
    GCC(Arrays.asList(OrderClaim.builder().claimCode("C").orderStateCode("CC").build()), Collections.emptyList()),
    //모바일쿠폰주문취소접수
    MCA(Arrays.asList(OrderClaim.builder().claimCode("C").orderStateCode("CA").build()), Collections.emptyList()),
    //모바일쿠폰주문취소완료
    MCC(Collections.emptyList(), Arrays.asList(OrderClaim.builder().orderStateCode("CC").build())),

    //일반상품반품접수
    GRA(Arrays.asList(OrderClaim.builder().claimCode("R").deliveryCode("R").orderStateCode("RA").build()), Collections.emptyList()),
    //모바일쿠폰반품접수
    MRA(Arrays.asList(OrderClaim.builder().claimCode("R").deliveryCode("R").orderStateCode("RA").build()), Collections.emptyList()),
    //반품완료
    RC(Collections.emptyList(), Arrays.asList(OrderClaim.builder().orderStateCode("RC").build())),
    //반품철회
    RW(Arrays.asList(OrderClaim.builder().claimCode("R").deliveryCode("D").orderStateCode("RW").build()), Collections.emptyList()),

    //교환접수
    EA(
            Arrays.asList(
                    OrderClaim.builder().claimCode("X").deliveryCode("R").orderStateCode("EA").build(),
                    OrderClaim.builder().claimCode("X").deliveryCode("D").orderStateCode("EA").build()
            ),
            Collections.emptyList()
    ),
    //교환철회
    EC(
            Arrays.asList(
                    OrderClaim.builder().claimCode("XC").deliveryCode("D").orderStateCode("EW").build(),
                    OrderClaim.builder().claimCode("XC").deliveryCode("D").orderStateCode("EW").build()
            ),
            Collections.emptyList()
    );

    private final List<OrderClaim> insertOrderClaim;
    private final List<OrderClaim> updateOrderClaim;
}
