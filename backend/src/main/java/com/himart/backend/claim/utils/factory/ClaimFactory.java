package com.himart.backend.claim.utils.factory;

import com.himart.backend.claim.utils.core.Claim;

public class ClaimFactory {

    public static Claim create(final String type){
        //T valueOf(String name) : String형 name과 일치하는 열겨형 상수를 반환
        return ClaimType.valueOf(type).getClaim();
    }

}
