package com.himart.backend.claim.service;

import com.himart.backend.claim.dto.ClaimDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClaimServiceTest {

    @Autowired
    ClaimService claimService;

    @Test
    @DisplayName("클레임 타입이 잘못되었을 경우 예외를 catch한 후 log를 남긴다.")
    void exception_catch_test(){
        ClaimDto claimDto = ClaimDto.builder().claimType("XXX").build();
        claimService.claim(claimDto);
    }

    @Test
    @DisplayName("일반상품주문취소 테스트")
    void general_prd_ordercancel_test(){
        ClaimDto claimDto = ClaimDto.builder().claimType("GCC").build();
        claimService.claim(claimDto);
    }

}