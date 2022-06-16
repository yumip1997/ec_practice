package com.himart.backend.order.utils.validator;

import com.himart.backend.order.dto.OrderRequest;
import com.himart.backend.order.dto.OrderValidationDto;

import java.util.function.Predicate;

public class OrderCommonValidator {

   public static Predicate<OrderValidationDto> isSellingProudct = (OrderValidationDto -> true);

}
