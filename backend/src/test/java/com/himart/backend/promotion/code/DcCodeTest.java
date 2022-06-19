package com.himart.backend.promotion.code;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class DcCodeTest {

    @Test
    void fixed_function_test(){
        Long discount = DcCode.getDiscountFunction("FD").apply(1000L, 100L);
        Assertions.assertThat(discount).isEqualTo(900L);
    }

    @Test
    void rate_function_test(){
        Long discount = DcCode.getDiscountFunction("RD").apply(1500L, 11L);
        Assertions.assertThat(discount).isEqualTo(1335L);
    }

}