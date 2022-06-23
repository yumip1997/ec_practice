package com.himart.backend.claim.utils.factory;

import com.himart.backend.claim.code.ClaimProcessorType;
import com.himart.backend.claim.utils.processor.ClaimProcessor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ClaimProcessorFactory {

    private final Map<ClaimProcessorType, ClaimProcessor> map = new HashMap<>();

    public ClaimProcessorFactory(List<ClaimProcessor> claimProcessorList){
        claimProcessorList.forEach(claimProcessor -> map.put(claimProcessor.getType(), claimProcessor));
    }

    public ClaimProcessor getClaimProcessor(ClaimProcessorType claimProcessorType){
        return map.get(claimProcessorType);
    }
}
