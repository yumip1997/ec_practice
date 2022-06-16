package com.himart.backend.order.utils.validator;

import com.himart.backend.order.dto.OrderRequest;

import java.util.function.Predicate;

public class OrderTypeValidator {

    public static Predicate<OrderRequest> isEcouponOrderAbleProduct = (orderRequest -> true);
}
