package com.himart.backend.order.utils.validator;

import com.himart.backend.order.dto.OrderProductView;
import com.himart.backend.order.dto.OrderRequest;

import java.util.function.BiPredicate;

public class OrderProductValidator {

    //BiPredicate?
    public static BiPredicate<OrderRequest, OrderProductView> validateMaxPurchaseCnt = (orderRequest, orderProductView) -> true;
    public static BiPredicate<OrderRequest, OrderProductView> validateMinPurchaseCnt = (orderRequest, orderProductView) -> true;
}
