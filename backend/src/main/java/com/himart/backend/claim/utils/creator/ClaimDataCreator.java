package com.himart.backend.claim.utils.creator;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.ClaimInsertBase;
import com.himart.backend.claim.model.ClaimUpdateBase;

public interface ClaimDataCreator{

    ClaimInsertBase getInsertData(ClaimDto claimDto);
    ClaimUpdateBase getUpdateData(ClaimDto claimDto);
}
