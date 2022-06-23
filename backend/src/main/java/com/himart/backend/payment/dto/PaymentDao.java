package com.himart.backend.payment.dto;

import com.himart.backend.claim.dto.OrderPayment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {

    Long insertApproveData(OrderPayment orderPayment);
}
