package com.himart.backend.order.utils.creator;

import com.himart.backend.claim.model.OrderClaim;
import com.himart.backend.order.dto.OrderProductView;
import com.himart.backend.order.dto.OrderRequest;
import com.himart.backend.order.model.OrderBase;
import com.himart.backend.order.model.OrderProduct;

public class OrderModelCreator {

    public static OrderBase commonOrderBase(OrderRequest orderRequest, OrderProductView orderProductView){
        return null;
    }

    public static OrderProduct commonOrderProduct(OrderRequest orderRequest, OrderProductView orderProductView){
        return null;
    }

    public static OrderClaim commonOrderClaim(OrderRequest orderRequest, OrderProductView orderProductView){
        return null;
    }
}
