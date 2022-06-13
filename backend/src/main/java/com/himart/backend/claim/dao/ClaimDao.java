package com.himart.backend.claim.dao;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.OrderClaim;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClaimDao {

    OrderClaim selectClaim(ClaimDto claimDto);
    OrderClaim insertClaim(ClaimDto claimDto);
    void updateClaim(OrderClaim orderClaim);
    void updateOrgOrderCancelCnt(ClaimDto claimDto);

}
