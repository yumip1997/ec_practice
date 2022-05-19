package com.himart.backend.claim.utils.factory;

import com.himart.backend.claim.utils.core.Claim;

public class ClaimFactory {

    public static Claim create(ClaimType claimType){
        //T valueOf(String name) : String형 name과 일치하는 열겨형 상수를
        return ClaimType.valueOf(claimType.name()).getClaim();
    }

}
