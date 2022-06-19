package com.himart.backend.claim.service;

import com.himart.backend.claim.com.code.ClaimException;
import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.factory.ClaimFactory;
import com.himart.backend.claim.utils.processor.ClaimProcessor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ClaimService {
    /*
    요청 업무에 따른 클레임 객체를 생성한 후 클레임 로직을 수행한다.
     */
    public void claim(ClaimDto claimDto){

        try{
            ClaimProcessor claimProcessor = ClaimFactory.findClaimProcessor(claimDto.getClaimType());
            claimProcessor.doProcess(claimDto);
        }catch (Exception e){
            log.error(ClaimException.INVALID_CLAIM_TYPE.EXCEPTION_MSG);
        }

    }
}
