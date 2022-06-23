package com.himart.backend.claim.utils.define;

import com.himart.backend.claim.code.ClaimException;
import com.himart.backend.claim.code.ClaimProcessorType;
import com.himart.backend.claim.code.ClaimValidatorType;
import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.define.creator.OrderClaimBaseCode;
import com.himart.backend.claim.utils.define.validation.ClaimValidStatusCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ClaimDefine {

    //일반상품주문취소완료
    GCC(ClaimProcessorType.COMPLETE, ClaimValidatorType.COMPLETE, ClaimValidStatusCode.GCC, Boolean.TRUE, OrderClaimBaseCode.GCC),
    //모바일쿠폰주문취소접수
    MCA(ClaimProcessorType.ACCEPT_WITHDRAWAL, ClaimValidatorType.ACCEPT_WITHDRAWAL, ClaimValidStatusCode.MCA, Boolean.TRUE, OrderClaimBaseCode.MCA),
    //모바일쿠폰주문취소완료
    MCC(ClaimProcessorType.COMPLETE, ClaimValidatorType.COMPLETE, ClaimValidStatusCode.MCC, Boolean.FALSE, OrderClaimBaseCode.MCC),

    //반품접수
    RA(ClaimProcessorType.ACCEPT_WITHDRAWAL, ClaimValidatorType.ACCEPT_WITHDRAWAL, ClaimValidStatusCode.RA, Boolean.TRUE, OrderClaimBaseCode.RA),
    //반품철회
    RW(ClaimProcessorType.ACCEPT_WITHDRAWAL, ClaimValidatorType.ACCEPT_WITHDRAWAL, ClaimValidStatusCode.RW, Boolean.TRUE, OrderClaimBaseCode.RW),

    //교환접수
    EA(ClaimProcessorType.ACCEPT_WITHDRAWAL, ClaimValidatorType.ACCEPT_WITHDRAWAL, ClaimValidStatusCode.EA, Boolean.TRUE, OrderClaimBaseCode.EA),
    //교환철회
    EW(ClaimProcessorType.ACCEPT_WITHDRAWAL, ClaimValidatorType.ACCEPT_WITHDRAWAL, ClaimValidStatusCode.EW, Boolean.TRUE, OrderClaimBaseCode.EW);

    private final ClaimProcessorType claimProcessorType;
    private final ClaimValidatorType claimValidatorType;
    private final ClaimValidStatusCode claimValidStatusCode;
    private final Boolean numFlag;
    private final OrderClaimBaseCode orderClaimBaseCode;

    public static ClaimProcessorType findClaimProcessorType(ClaimDto claimDto) throws Exception {
        try{
            return ClaimDefine.valueOf(claimDto.getClaimType()).getClaimProcessorType();
        }catch (Exception e){
            throw new Exception(ClaimException.INVALID_CLAIM_TYPE.EXCEPTION_MSG);
        }
    }

    public static ClaimValidatorType findClaimValidatorType(ClaimDto claimDto) throws Exception {
        try{
            return ClaimDefine.valueOf(claimDto.getClaimType()).getClaimValidatorType();
        }catch (Exception e){
            throw new Exception(ClaimException.INVALID_CLAIM_TYPE.EXCEPTION_MSG);
        }
    }

    public static ClaimValidStatusCode findClaimValidStatusCode(ClaimDto claimDto) throws Exception {
        try{
            return ClaimDefine.valueOf(claimDto.getClaimType()).getClaimValidStatusCode();
        }catch (Exception e){
            throw new Exception(ClaimException.INVALID_CLAIM_TYPE.EXCEPTION_MSG);
        }
    }

    public static Boolean findNumFlag(ClaimDto claimDto) throws Exception{
        try{
            return ClaimDefine.valueOf(claimDto.getClaimType()).getNumFlag();
        }catch (Exception e){
            throw new Exception(ClaimException.INVALID_CLAIM_TYPE.EXCEPTION_MSG);
        }

    }

    public static OrderClaimBaseCode findOrderClaimBaseCode(ClaimDto claimDto) throws Exception{
        try {
            return ClaimDefine.valueOf(claimDto.getClaimType()).getOrderClaimBaseCode();
        }catch (Exception e){
            throw new Exception(ClaimException.INVALID_CLAIM_TYPE.EXCEPTION_MSG);
        }
    }

}
