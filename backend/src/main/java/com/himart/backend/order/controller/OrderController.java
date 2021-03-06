package com.himart.backend.order.controller;

import com.himart.backend.order.dto.OrderRequest;
import com.himart.backend.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public void order(@RequestBody OrderRequest orderRequest){
        try{
            orderService.order(orderRequest);
        }catch (Exception e){
            log.error(e.getMessage());
        }

    }

}
