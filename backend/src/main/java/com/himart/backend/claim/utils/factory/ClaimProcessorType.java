package com.himart.backend.claim.utils.factory;

import com.himart.backend.claim.dao.ClaimDao;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import com.himart.backend.claim.utils.helper.IFCallHelper;
import com.himart.backend.claim.utils.manipulator.ClaimDataManipulator;
import com.himart.backend.claim.utils.processor.AcceptProcessor;
import com.himart.backend.claim.utils.processor.ClaimProcessor;
import com.himart.backend.claim.utils.processor.CompleteProcessor;
import com.himart.backend.claim.utils.processor.WithdrawalProcessor;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

@RequiredArgsConstructor
public enum ClaimProcessorType {

    //접수
    AC(() -> (AcceptProcessor.getInstance(new ClaimValidator(), new ClaimDataCreator(), new ClaimDataManipulator()))),
    //완료
    CP(() -> (CompleteProcessor.getInstance(new ClaimValidator(), new ClaimDataCreator(), new ClaimDataManipulator(), new IFCallHelper()))),
    //철회
    WD(() -> (WithdrawalProcessor.getInstance(new ClaimValidator(), new ClaimDataCreator())));

    private final Supplier<ClaimProcessor> supplier;

    public ClaimProcessor getClaimProcessor(){
        return supplier.get();
    }
}
