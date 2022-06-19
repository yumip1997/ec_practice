package com.himart.backend.claim.service;

import com.himart.backend.claim.dto.ClaimDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClaimServiceTest {

    @Test
    @DisplayName("클레임 타입이 잘못되었을 경우 예외를 catch한 후 log를 남긴다.")
    void exceptionTest(){
        ClaimService claimService = new ClaimService();
        ClaimDto claimDto = ClaimDto.builder().claimType("XXX").build();
        claimService.claim(claimDto);
    }

}