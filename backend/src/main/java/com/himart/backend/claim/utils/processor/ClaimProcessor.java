package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;

public interface ClaimProcessor {

   void doValidationProcess(ClaimDto claimDto) throws Exception;
   void doClaimDataManipulationProcess(ClaimDto claimDto);
   void verifyAmount(ClaimDto claimDto) throws Exception;
   void doProcess(ClaimDto claimDto);


}
