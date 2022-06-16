package com.himart.backend.order.utils.validator;

import com.himart.backend.order.dto.OrderRequest;

import java.util.function.Predicate;

public class OrderCommonValidator {

   public static Predicate<OrderRequest> isSellingProudct = (orderRequest -> true);

}
