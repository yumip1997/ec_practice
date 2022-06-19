package com.himart.backend.order.service;

import com.himart.backend.order.code.OrderType;
import com.himart.backend.order.code.SystemType;
import com.himart.backend.order.dto.OrderRequest;
import com.himart.backend.order.utils.after.AfterStrategy;
import com.himart.backend.order.utils.after.impl.BOAfterStrategy;
import com.himart.backend.order.utils.after.impl.FOAfterStrategy;
import com.himart.backend.order.utils.creator.DataStrategy;
import com.himart.backend.order.utils.creator.impl.ECouponDataStrategy;
import com.himart.backend.order.utils.creator.impl.GeneralDataStrategy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    @DisplayName("주문 유형이 올바르지 않을 경우 예외가 발생한다")
    void invalid_orderType(){
        //given
        OrderRequest orderRequest = OrderRequest.builder().orderType("xxx").build();

        //then
        assertThrows(Exception.class, () -> orderService.order(orderRequest));
    }

    @Test
    @DisplayName("시스템 유형이 올바르지 않을 경우 예외가 발생한다")
    void invalid_systemType(){
        //given
        OrderRequest orderRequest = OrderRequest.builder().systemType("xxx").build();

        //then
        assertThrows(Exception.class, () -> orderService.order(orderRequest));
    }


    @Test
    @DisplayName("일반주문 요청 시 GeneralDataStrategy 타입의 객체가 반환된다.")
    void general_dataStrategy_test() throws Exception {
        //given
        OrderRequest orderRequest = OrderRequest.builder().orderType(OrderType.GENERAL.getCode()).build();

        //when
        DataStrategy dataStrategy = orderService.getDataStrategy(orderRequest);

        //then
        Assertions.assertThat(dataStrategy).isInstanceOf(GeneralDataStrategy.class);
    }

    @Test
    @DisplayName("모바일 쿠폰 요청 시 GeneralDataStrategy 타입의 객체가 반환된다.")
    void ecoupon_dataStrategy_test() throws Exception {
        //given
        OrderRequest orderRequest = OrderRequest.builder().orderType(OrderType.ECOUPON.getCode()).build();

        //when
        DataStrategy dataStrategy = orderService.getDataStrategy(orderRequest);

        //then
        Assertions.assertThat(dataStrategy).isInstanceOf(ECouponDataStrategy.class);
    }

    @Test
    @DisplayName("FO 요청 시 FOAfterStrategy 타입의 객체가 반환된다.")
    void fo_afterStrategy_test() throws Exception {
        //given
        OrderRequest orderRequest = OrderRequest.builder().systemType(SystemType.FO.getCode()).build();

        //when
        AfterStrategy dataStrategy = orderService.getAfterStrategy(orderRequest);

        //then
        Assertions.assertThat(dataStrategy).isInstanceOf(FOAfterStrategy.class);
    }

    @Test
    @DisplayName("BO 요청 시 BOAfterStrategy 타입의 객체가 반환된다.")
    void bo_afterStrategy_test() throws Exception {
        //given
        OrderRequest orderRequest = OrderRequest.builder().systemType(SystemType.BO.getCode()).build();

        //when
        AfterStrategy dataStrategy = orderService.getAfterStrategy(orderRequest);

        //then
        Assertions.assertThat(dataStrategy).isInstanceOf(BOAfterStrategy.class);
    }
}