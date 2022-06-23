package com.himart.backend.order.utils.factory;

import com.himart.backend.order.code.OrderType;
import com.himart.backend.order.utils.creator.DataStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataStrategyFactory {

    private final Map<OrderType, DataStrategy> map = new HashMap<>();

    public DataStrategyFactory(List<DataStrategy> dataStrategyList){
        dataStrategyList.forEach(dataStrategy -> map.put(dataStrategy.getType(), dataStrategy));
    }

    public DataStrategy getDataStrategy(OrderType orderType){
        return map.get(orderType);
    }
}
