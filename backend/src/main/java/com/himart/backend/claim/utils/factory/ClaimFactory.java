package com.himart.backend.claim.utils.factory;


import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import com.himart.backend.claim.utils.creator.impl.*;
import com.himart.backend.claim.utils.processor.ClaimProcessor;
import com.himart.backend.claim.utils.processor.impl.CommonProcessor;
import com.himart.backend.claim.utils.processor.impl.CompleteProcessor;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import com.himart.backend.claim.utils.validator.impl.ClaimCommonValidator;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

@RequiredArgsConstructor
public enum ClaimFactory {
    //일반상품주문취소완료
    GCC(CompleteProcessor::getInstance, GeneralCancelDataCreator::getInstance, ClaimCommonValidator::getInstance),
    //모바일쿠폰주문취소접수
    MCA(CommonProcessor::getInstance, EcouponCancelAcceptDataCreator::getInstance, ClaimCommonValidator::getInstance),
    //모바일쿠폰주문취소완료
    MCC(CompleteProcessor::getInstance, EcouponCancelCompleteDataCreator::getInstance, ClaimCommonValidator::getInstance),

    //반품접수
    RA(CommonProcessor::getInstance, ReturnAcceptDataCreator::getInstance, ClaimCommonValidator::getInstance),
    //반품완료
    RC(CompleteProcessor::getInstance, ReturnCompleteDataCreator::getInstance, ClaimCommonValidator::getInstance),
    //반품철회
    RW(CommonProcessor::getInstance, ReturnWithdrawalDataCreator::getInstance, ClaimCommonValidator::getInstance),

    //교환접수
    EA(CommonProcessor::getInstance, ExchangeAcceptDataCreator::getInstance, ClaimCommonValidator::getInstance),
    //교환철회
    EC(CommonProcessor::getInstance, ExchangeWithdrawalDataCreator::getInstance, ClaimCommonValidator::getInstance);

    private final Supplier<ClaimProcessor> claimProcessorSupplier;
    private final Supplier<ClaimDataCreator> claimDataCreatorSupplier;
    private final Supplier<ClaimValidator> claimValidatorSupplier;

    //TODO 이름 잘못들어오면 예외 throw
    public static ClaimProcessor findClaimProcessor(String name){
        return ClaimFactory.valueOf(name).claimProcessorSupplier.get();
    }

    public static ClaimDataCreator findClaimDataCreator(String name){
        return ClaimFactory.valueOf(name).claimDataCreatorSupplier.get();
    }

    public static ClaimValidator findClaimValidator(String name){
        return ClaimFactory.valueOf(name).claimValidatorSupplier.get();
    }

}
