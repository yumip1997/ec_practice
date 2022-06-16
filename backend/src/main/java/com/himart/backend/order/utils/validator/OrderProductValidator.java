package com.himart.backend.order.utils.validator;

import com.himart.backend.order.dto.OrderProductView;
import com.himart.backend.order.dto.OrderRequest;
import com.himart.backend.order.dto.OrderValidationDto;

import java.util.function.Predicate;

public class OrderProductValidator {

    public static Predicate<OrderValidationDto> validateMaxPurchaseCnt = (orderValidationDto) -> true;
    public static Predicate<OrderValidationDto> validateMinPurchaseCnt = (orderValidationDto) -> true;

}
