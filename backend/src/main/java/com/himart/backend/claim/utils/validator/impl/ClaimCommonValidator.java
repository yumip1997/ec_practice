package com.himart.backend.claim.utils.validator.impl;

import com.himart.backend.claim.com.code.ClaimException;
import com.himart.backend.claim.dao.ClaimDao;
import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.model.OrderClaim;
import com.himart.backend.claim.utils.factory.ClaimFactory;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import com.himart.backend.claim.utils.validator.code.ClaimValidStatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ClaimCommonValidator implements ClaimValidator {

    private final ClaimDao claimDao;
    private static ClaimValidator claimValidator;

    @PostConstruct
    void init(){
        claimValidator = this;
    }

    public static ClaimValidator getInstance(){
        return claimValidator;
    }

    @Override
    public void isValid(ClaimDto claimDto) throws Exception {
        isValidOrderdStatus(claimDto);
        isValidProductType(claimDto);
        isValidAmount(claimDto);
    }

    //주문상태체크
    public void isValidOrderdStatus(ClaimDto claimDto) throws Exception {
        OrderClaim currentClaim = null; // TODO claimDao.selectClaim(claimDto);
        String currentClaimProcess = currentClaim.getClaimCode();
        List<String> validStatusList =  ClaimValidStatusCode.valueOf(claimDto.getClaimType()).getValidOrderStatus();

        if(isContainInList(validStatusList, currentClaimProcess)) return;

        throw new Exception(ClaimException.INVALID_ORDER_STATUS.EXCEPTION_MSG);
    }

    //상품유형체크
    public void isValidProductType(ClaimDto claimDto) throws Exception{
        String currentPrdType = claimDto.getProductType();
        List<String> validPrdTypeList = ClaimValidStatusCode.valueOf(claimDto.getClaimType()).getValidProductType();

        if(isContainInList(validPrdTypeList, currentPrdType)) return;

        throw new Exception(ClaimException.INVALID_PRD_TPYE.EXCEPTION_MSG);
    }

    private boolean isContainInList(List<String> list, String target){
        return list.contains(target);
    }

    //금액체크(UI에서 받은 금액과 일치여부, 주문금액, 취소금액, 환불가능금액)
    public void isValidAmount(ClaimDto claimDto) throws Exception{

    }

    //금액검증(주문번호, 클레임 번호)
    //1. 취소 금액 == 클레임 금액
    //2. UI 데이터 == 쿼리 결과(환불가능금액) 검증데이터
    @Override
    public void verifyAmount(ClaimDto claimDto) throws Exception {

    }
}
