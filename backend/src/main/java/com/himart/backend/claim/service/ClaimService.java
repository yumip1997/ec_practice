package com.himart.backend.claim.service;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.factory.ClaimFactory;
import org.springframework.stereotype.Service;

@Service
public class ClaimService {

    public void claim(ClaimDto claimDto){
        ClaimFactory
                .create(claimDto.getClaimType())
                .execute(claimDto);
    }

}
