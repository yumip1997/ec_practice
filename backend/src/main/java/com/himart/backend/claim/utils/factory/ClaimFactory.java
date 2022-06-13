package com.himart.backend.claim.utils.factory;

import com.himart.backend.claim.utils.core.Claim;

public class ClaimFactory {

    public static Claim getClaimByType(String claimType) throws Exception {
        return ClaimType.findClaimType(claimType).getClaim();
    }
}
