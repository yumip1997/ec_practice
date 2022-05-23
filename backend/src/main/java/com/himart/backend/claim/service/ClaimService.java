package com.himart.backend.claim.service;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.factory.ClaimFactory;
import org.springframework.stereotype.Service;

@Service
public class ClaimService {
    /*
    요청 업무에 따른 클레임 객체를 생성한 후 클레임 로직을 수행한다.
     */
    public void claim(ClaimDto claimDto){
        ClaimFactory
                .getClaimByType(claimDto.getClaimType())
                .execute(claimDto);
    }
}
