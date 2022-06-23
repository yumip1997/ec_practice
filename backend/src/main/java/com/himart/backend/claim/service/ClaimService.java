package com.himart.backend.claim.service;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.define.ClaimDefine;
import com.himart.backend.claim.utils.factory.ClaimProcessorFactory;
import com.himart.backend.claim.code.ClaimProcessorType;
import com.himart.backend.claim.utils.processor.ClaimProcessor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class ClaimService {

    private final ClaimProcessorFactory claimProcessorFactory;

    public void claim(ClaimDto claimDto){

        try{
            ClaimProcessorType claimProcessorType = ClaimDefine.findClaimProcessorType(claimDto);
            ClaimProcessor claimProcessor = claimProcessorFactory.getClaimProcessor(claimProcessorType);

            claimProcessor.doProcess(claimDto);
        }catch (Exception e){
            log.error(e.getMessage());
        }

    }
}
