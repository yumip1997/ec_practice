package com.himart.backend.claim.utils.factory;

import com.himart.backend.claim.utils.core.Claim;
import com.himart.backend.claim.utils.core.Exchange;
import com.himart.backend.claim.utils.core.OrderCancel;
import com.himart.backend.claim.utils.core.Return;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import com.himart.backend.claim.utils.manipulator.ClaimDataManipulator;
import com.himart.backend.claim.utils.processor.AcceptProcessor;
import com.himart.backend.claim.utils.processor.CompleteProcessor;
import com.himart.backend.claim.utils.processor.WithdrawalProcessor;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import lombok.RequiredArgsConstructor;

import java.util.function.Supplier;

@RequiredArgsConstructor
public enum ClaimType {

    //교환접수
    EA(() -> (Exchange.getInstance(AcceptProcessor.getInstance(new ClaimValidator(), new ClaimDataCreator(), new ClaimDataManipulator())))),
    //교환완료
    EC(() -> (Exchange.getInstance(CompleteProcessor.getInstance(new ClaimValidator(), new ClaimDataCreator())))),
    //교환철회
    EW(() -> (Exchange.getInstance(WithdrawalProcessor.getInstance(new ClaimValidator(), new ClaimDataCreator())))),
    //반품접수
    RA(() ->(Return.getInstance(AcceptProcessor.getInstance(new ClaimValidator(), new ClaimDataCreator(), new ClaimDataManipulator())))),
    //반품완료
    RC(() ->(Return.getInstance(CompleteProcessor.getInstance(new ClaimValidator(), new ClaimDataCreator())))),
    //반품철회
    RW(() ->(Return.getInstance(WithdrawalProcessor.getInstance(new ClaimValidator(), new ClaimDataCreator())))),
    //주문취소완료
    OC(() -> (OrderCancel.getInstance(CompleteProcessor.getInstance(new ClaimValidator(), new ClaimDataCreator())))),
    //주문취소접수
    OA(() -> (OrderCancel.getInstance(AcceptProcessor.getInstance(new ClaimValidator(), new ClaimDataCreator(), new ClaimDataManipulator()))));

    private final Supplier<Claim> supplier;

    public Claim getClaim(){
        return supplier.get();
    }
}
