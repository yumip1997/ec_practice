package com.himart.backend.claim.utils.validator;

import com.himart.backend.claim.code.ClaimException;
import com.himart.backend.claim.code.ClaimProcessCode;
import com.himart.backend.claim.code.ClaimProcessorType;
import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.OrderClaim;
import com.himart.backend.claim.utils.define.ClaimDefine;
import com.himart.backend.com.utils.FactoryTemplate;

import java.util.List;

public abstract class ClaimValidator implements FactoryTemplate<ClaimProcessorType> {

    abstract public void isValid(ClaimDto claimDto) throws Exception;

    abstract public void verifyAmount(ClaimDto claimDto) throws Exception;

    public void isValidOrderdStatus(ClaimDto claimDto) throws Exception {
        OrderClaim currentClaim = OrderClaim.builder().orderStateCode(ClaimProcessCode.ORDER_COMPLETE.code).build();

        String currentClaimProcess = currentClaim.getOrderStateCode();
        List<String> validStatusList =  ClaimDefine.findClaimValidStatusCode(claimDto)
                .getClaimValidProcessCode()
                .getValidOrderStatusList();

        if(isContainInList(validStatusList, currentClaimProcess)) return;

        throw new Exception(ClaimException.INVALID_ORDER_STATUS.EXCEPTION_MSG);
    }

    public void isValidProductType(ClaimDto claimDto) throws Exception{
        String currentPrdType = claimDto.getProductType();
        List<String> validPrdTypeList = ClaimDefine.findClaimValidStatusCode(claimDto)
                .getClaimValidProdutTypeCode()
                .getValidProductTypeList();

        if(isContainInList(validPrdTypeList, currentPrdType)) return;

        throw new Exception(ClaimException.INVALID_PRD_TPYE.EXCEPTION_MSG);
    }

    private boolean isContainInList(List<String> list, String target){
        return list.contains(target);
    }

}

