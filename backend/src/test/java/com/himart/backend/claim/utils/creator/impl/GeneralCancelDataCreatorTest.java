package com.himart.backend.claim.utils.creator.impl;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.ClaimInsertBase;
import com.himart.backend.claim.model.OrderClaim;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class GeneralCancelDataCreatorTest {

    @Autowired
    GeneralCancelDataCreator generalCancelDataCreator;

    @Test
    @DisplayName("주문 클레임 테이블에 INSERT 될 ROW")
    void getOrderClaimList_test(){
        //given
        ClaimDto claimDto = ClaimDto.builder().claimType("GCC").build();

        //when
        ClaimInsertBase claimInsertBase = generalCancelDataCreator.getInsertData(claimDto);
        List<OrderClaim> list = claimInsertBase.getOrderClaimList();

        //then
        assertTrue(list.get(0).getClaimCode().equals("C"));
        assertTrue(list.get(0).getOrderStateCode().equals("CC"));

    }
}