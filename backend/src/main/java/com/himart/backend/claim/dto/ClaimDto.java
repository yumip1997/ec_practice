package com.himart.backend.claim.dto;

import com.himart.backend.claim.utils.factory.ClaimType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClaimDto {
    private ClaimType claimType;
}
