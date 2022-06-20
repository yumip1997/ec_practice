package com.himart.backend.claim.utils.processor.impl;

import com.himart.backend.claim.dto.ClaimDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompleteProcessorTest {

    @Autowired
    private CompleteProcessor completeProcessor;

    @Test
    @DisplayName("일반주문취소완료 데이터 조작 프로세스")
    void ordercancel_manipulate_process(){
        ClaimDto claimDto = ClaimDto.builder().claimType("GCC").build();
    }

}