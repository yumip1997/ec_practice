package com.himart.backend.order.utils.validator;

import com.himart.backend.order.dto.OrderRequest;
import com.himart.backend.order.dto.OrderValidationDto;

import java.util.function.Predicate;

public class OrderTypeValidator {

    public static Predicate<OrderValidationDto> isGeneralOrderAbleProduct = (orderRequest -> true);
    public static Predicate<OrderValidationDto> isEcouponOrderAbleProduct = (orderRequest -> true);

}
