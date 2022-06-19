package com.himart.backend.claim.utils.validator.code;

import com.himart.backend.claim.com.code.ClaimProcessCode;
import com.himart.backend.claim.com.code.ProductTypeCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Getter
public enum ClaimValidStatusCode {

    //일반상품주문취소완료
    GCC(Arrays.asList(ClaimProcessCode.ORDER_COMPLETE.code), Arrays.asList(ProductTypeCode.GENERAL.code)),
    //모바일쿠폰주문취소접수
    MCA(Arrays.asList(ClaimProcessCode.ORDER_COMPLETE.code), Arrays.asList(ProductTypeCode.ECOUPON.code)),
    //모바일쿠폰주문취소완료
    MCC(Arrays.asList(ClaimProcessCode.CANCEL_ACCEPT.code), Arrays.asList(ProductTypeCode.ECOUPON.code)),

    //반품접수
    RA(Arrays.asList(ClaimProcessCode.DELIVERY_COMPLETE.code), Arrays.asList(ProductTypeCode.GENERAL.code, ProductTypeCode.ECOUPON.code)),
    //반품완료
    RC(
            Arrays.asList(ClaimProcessCode.RETRIEVE_INSTRUCT.code, ClaimProcessCode.RETRIEVE_COMPLETE.code, ClaimProcessCode.RETURN_COMPLETE.code),
            Arrays.asList(ProductTypeCode.GENERAL.code, ProductTypeCode.ECOUPON.code)
    ),
    //반품철회
    RW(Arrays.asList(ClaimProcessCode.RETURN_ACCEPT.code), Arrays.asList(ProductTypeCode.GENERAL.code, ProductTypeCode.ECOUPON.code)),

    //교환접수
    EA(Arrays.asList(ClaimProcessCode.DELIVERY_COMPLETE.code), Arrays.asList(ProductTypeCode.GENERAL.code)),
    //교환철회
    EC(Arrays.asList(ClaimProcessCode.EXCHANGE_ACCEPT.code), Arrays.asList(ProductTypeCode.GENERAL.code));

    private final List<String> validOrderStatus;
    private final List<String> validProductType;
}
