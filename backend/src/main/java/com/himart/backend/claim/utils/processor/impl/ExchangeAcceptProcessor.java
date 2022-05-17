package com.himart.backend.claim.utils.processor.impl;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.creator.impl.ExchangeAcceptDataCreator;
import com.himart.backend.claim.utils.processor.abstract_.AcceptProcessor;
import com.himart.backend.claim.utils.validator.impl.ExchangeAcceptValidator;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
public class ExchangeAcceptProcessor extends AcceptProcessor {

    private final ExchangeAcceptValidator exchangeAcceptValidator;
    private final ExchangeAcceptDataCreator exchangeAcceptDataCreator;

    @Override
    public void doValidationProcess(ClaimDto claimDto) {
        System.out.println("교환접수 validation 실행");
        exchangeAcceptValidator.isValid(claimDto);
    }

    @Override
    public void doDataCreationProcess(ClaimDto claimDto) {
        System.out.println("교환접수 data creation 실행");
    }

    @Override
    public void doIFCallProcess(ClaimDto claimDto) {
        System.out.println("교환접수 외부 API 호출 실행");
    }
}
