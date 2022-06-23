package com.himart.backend.claim.utils.factory;

import com.himart.backend.claim.code.ClaimValidatorType;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ClaimValidatorFactory {

    private final Map<ClaimValidatorType, ClaimValidator> map = new HashMap<>();

    public ClaimValidatorFactory(List<ClaimValidator> claimValidatorList){
        claimValidatorList.forEach(claimValidator -> map.put(claimValidator.getType(), claimValidator));
    }

    public ClaimValidator getClaimValidator(ClaimValidatorType claimValidatorType){
        return map.get(claimValidatorType);
    }
}


