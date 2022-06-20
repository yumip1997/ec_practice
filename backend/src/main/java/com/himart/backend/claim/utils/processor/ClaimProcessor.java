package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.dto.LogDto;
import com.himart.backend.claim.model.ClaimInsertBase;
import com.himart.backend.claim.model.ClaimUpdateBase;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import com.himart.backend.claim.utils.factory.ClaimFactory;
import com.himart.backend.claim.utils.helper.ClaimDataManipulateHelper;
import com.himart.backend.claim.utils.helper.MonitoringLogHelper;
import com.himart.backend.claim.utils.processor.code.ClaimNumFlagCode;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class ClaimProcessor {

   protected final MonitoringLogHelper monitoringLogHelper;
   protected final ClaimDataManipulateHelper claimDataManipulateHelper;

   protected void setUpClaimNum(ClaimDto claimDto){
      boolean flag = ClaimNumFlagCode.valueOf(claimDto.getClaimType()).getFlag();
      if(!flag) return;

      String claimNum = getClaimNumber();
      claimDto.setClaimNo(claimNum);
   }

   private String getClaimNumber(){
      return "";
   }

   protected void doValidationProcess(ClaimDto claimDto) throws Exception{
      ClaimValidator claimValidator = ClaimFactory.findClaimValidator(claimDto.getClaimType());
      claimValidator.isValid(claimDto);
   }

   protected LogDto doClaimDataManipulationProcess(ClaimDto claimDto){
      ClaimDataCreator claimDataCreator = ClaimFactory.findClaimDataCreator(claimDto.getClaimType());
      ClaimInsertBase claimInsertBase = insertClaim(claimDataCreator.getInsertData(claimDto));
      ClaimUpdateBase claimUpdateBase = updateClaim(claimDataCreator.getUpdateData(claimDto));
      return LogDto.builder().insertData(claimInsertBase).updateData(claimUpdateBase).build();
   }

   private ClaimInsertBase insertClaim(ClaimInsertBase claimInsertBase) {
      claimDataManipulateHelper.insertClaimData(claimInsertBase);
      return claimInsertBase;
   }

   private ClaimUpdateBase updateClaim(ClaimUpdateBase claimUpdateBase) {
      claimDataManipulateHelper.updateClaimData(claimUpdateBase);
      return claimUpdateBase;
   }

   protected void verifyAmount(ClaimDto claimDto) throws Exception {
      ClaimValidator claimValidator = ClaimFactory.findClaimValidator(claimDto.getClaimType());
      claimValidator.verifyAmount(claimDto);
   }
   public abstract void doProcess(ClaimDto claimDto);

}
