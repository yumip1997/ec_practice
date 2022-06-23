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
    @DisplayName("일반주문취소완료 프로세스 확인")
    void test_gcc(){
        ClaimDto claimDto = ClaimDto.builder().claimType("GCC").productType("G").build();
        claimService.claim(claimDto);
    }

    @Test
    @DisplayName("반품접수 프로세스 확인")
    void test_ra(){
        ClaimDto claimDto = ClaimDto.builder().claimType("RA").productType("G").build();
        claimService.claim(claimDto);
    }

    @Test
    @DisplayName("반품철회 프로세스 확인")
    void test_rw(){
        ClaimDto claimDto = ClaimDto.builder().claimType("RW").productType("G").build();
        claimService.claim(claimDto);
    }
}