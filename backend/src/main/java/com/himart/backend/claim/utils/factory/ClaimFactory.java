package com.himart.backend.claim.utils.factory;

import com.himart.backend.claim.utils.core.Claim;

public class ClaimFactory {

    public static Claim create(ClaimType claimType){
        return ClaimType.valueOf(claimType.name()).getClaim();
    }

}
