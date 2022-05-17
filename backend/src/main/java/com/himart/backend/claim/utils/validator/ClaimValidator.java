package com.himart.backend.claim.utils.validator;

import com.himart.backend.claim.dto.ClaimDto;
import org.springframework.stereotype.Component;

@Component
public interface ClaimValidator {

    boolean isValid(ClaimDto claimDto);

    boolean isValidStatus(ClaimDto claimDto);

}
