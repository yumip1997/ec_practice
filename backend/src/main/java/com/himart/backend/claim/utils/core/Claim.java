package com.himart.backend.claim.utils.core;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.processor.ClaimProcessor;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
abstract public class Claim {
    protected final ClaimProcessor claimProcessor;
    abstract public void execute(ClaimDto claimDto);
}
