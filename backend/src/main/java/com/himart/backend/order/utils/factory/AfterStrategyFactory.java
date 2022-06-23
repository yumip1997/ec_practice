package com.himart.backend.order.utils.factory;

import com.himart.backend.order.code.OrderType;
import com.himart.backend.order.code.SystemType;
import com.himart.backend.order.utils.after.AfterStrategy;
import com.himart.backend.order.utils.creator.DataStrategy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AfterStrategyFactory {

    private final Map<SystemType, AfterStrategy> map = new HashMap<>();

    public AfterStrategyFactory(List<AfterStrategy> afterStrategyList){
        afterStrategyList.forEach(afterStrategy -> map.put(afterStrategy.getType(), afterStrategy));
    }

    public AfterStrategy getAfterStrategy(SystemType systemType){
        return map.get(systemType);
    }

}
