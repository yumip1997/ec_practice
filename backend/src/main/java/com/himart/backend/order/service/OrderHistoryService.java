package com.himart.backend.order.service;

import com.himart.backend.claim.utils.helper.MonitoringLogHelper;
import com.himart.backend.order.dto.OrderDto;
import com.himart.backend.order.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderHistoryService {

    private final MonitoringLogHelper monitoringLogHelper;

    public Long insertOrderHistory(OrderRequest orderRequest){
        return monitoringLogHelper.insertMonitoringLog(orderRequest.toString());
    }

    public void updateOrderHistory(OrderDto orderDto, Long historyNo){
        monitoringLogHelper.updateMonitoringLog(historyNo, orderDto.toString());
    }


}
