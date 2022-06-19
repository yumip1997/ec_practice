package com.himart.backend.order.utils.validator;

import com.himart.backend.order.dto.OrderValidationDto;

import java.util.function.Predicate;

public class OrderSystemTypeValidator {

    public static Predicate<OrderValidationDto> isFOOrderAbleProduct = (orderRequest -> true);
    public static Predicate<OrderValidationDto> isBOOrderAbleProduct = (orderRequest -> true);

}
