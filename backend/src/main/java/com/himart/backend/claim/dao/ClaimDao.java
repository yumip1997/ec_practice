package com.himart.backend.claim.dao;

import com.himart.backend.claim.com.code.ClaimProcessCode;
import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.ClaimBase;
import com.himart.backend.test.Claim;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClaimDao {

    ClaimBase selectClaim(ClaimDto claimDto);

    ClaimProcessCode getCurrentClaimProcessCode(ClaimDto claimDto);
}
