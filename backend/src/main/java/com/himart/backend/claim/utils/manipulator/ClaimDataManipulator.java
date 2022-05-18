package com.himart.backend.claim.utils.manipulator;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.core.Claim;

public interface ClaimDataManipulator {

    void insertOrderLog(ClaimDto claimDto);

    void updateOrderLog(ClaimDto claimDto);

    void insertClaimData(ClaimDto claimDto);
    void updateClaimData(ClaimDto claimDto);
}
