package com.himart.backend.claim.utils.validator.impl;

import com.himart.backend.claim.com.code.ProductTypeCode;
import com.himart.backend.claim.dao.ClaimDao;
import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.OrderBenefit;
import com.himart.backend.claim.model.OrderBenefitRelation;
import com.himart.backend.claim.model.OrderClaim;
import com.himart.backend.claim.model.OrderCost;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClaimCommonValidatorTest {

    @Autowired
    ClaimCommonValidator claimCommonValidator;

    @Test
    @DisplayName("상품유형이 모바일쿠폰일 경우 모바일쿠폰주문취소접수의 상품유형 유효셩 검증을 통과한다.")
    void ecoupon_ordercancel_accept_validProductType_test() throws Exception {
        ClaimDto claimDto = ClaimDto.builder().claimType("MCA").productType(ProductTypeCode.ECOUPON.code).build();
        claimCommonValidator.isValidProductType(claimDto);
    }

    @Test
    @DisplayName("상품유형이 일반상품일 경우 모바일쿠폰주문취소접수의 상품유형 유효셩 검증을 통과하지 못한다.")
    void ecoupon_ordercancel_accept_NotvalidOrderStatus_test() throws Exception {
        ClaimDto claimDto = ClaimDto.builder().claimType("MCA").productType(ProductTypeCode.GENERAL.code).build();

        assertThrows(Exception.class, () -> claimCommonValidator.isValidProductType(claimDto));
    }

}