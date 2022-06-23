package com.himart.backend.claim.utils.processor;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.dto.LogDto;
import com.himart.backend.claim.model.ClaimInsertBase;
import com.himart.backend.claim.model.ClaimUpdateBase;
import com.himart.backend.claim.utils.define.ClaimDefine;
import com.himart.backend.claim.utils.factory.ClaimValidatorFactory;
import com.himart.backend.claim.code.ClaimProcessorType;
import com.himart.backend.claim.code.ClaimValidatorType;
import com.himart.backend.claim.utils.helper.ClaimDataManipulateHelper;
import com.himart.backend.claim.utils.helper.MonitoringLogHelper;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import com.himart.backend.com.utils.FactoryTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RequiredArgsConstructor
@Log4j2
public abstract class ClaimProcessor implements FactoryTemplate<ClaimProcessorType> {

   private final ClaimValidatorFactory claimValidatorFactory;
   protected final MonitoringLogHelper monitoringLogHelper;
   protected final ClaimDataManipulateHelper claimDataManipulateHelper;

   public abstract void doProcess(ClaimDto claimDto);

   protected void setUpClaimNum(ClaimDto claimDto) throws Exception {
      log.info("클레임 채번 로직을 진행한다.");

      boolean flag = ClaimDefine.findNumFlag(claimDto);
      if(!flag) return;

      String claimNum = getClaimNumber();
      claimDto.setClaimNo(claimNum);
   }

   private String getClaimNumber(){
      return "";
   }

   protected void doValidationProcess(ClaimDto claimDto) throws Exception{
      ClaimValidatorType claimValidatorType = ClaimDefine.findClaimValidatorType(claimDto);
      ClaimValidator claimValidator = claimValidatorFactory.getClaimValidator(claimValidatorType);

      claimValidator.isValid(claimDto);
   }

   protected LogDto doClaimDataManipulationProcess(ClaimDto claimDto){
      return null;
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
      ClaimValidatorType claimValidatorType = ClaimDefine.findClaimValidatorType(claimDto);
      ClaimValidator claimValidator = claimValidatorFactory.getClaimValidator(claimValidatorType);

      claimValidator.verifyAmount(claimDto);
   }

}
