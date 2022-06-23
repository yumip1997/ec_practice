package com.himart.backend.payment.dto;

import com.himart.backend.claim.model.OrderPayment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {

    Long insertApproveData(OrderPayment orderPayment);
}
