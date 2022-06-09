package com.himart.backend.claim.utils.validator;

import com.himart.backend.claim.com.code.ClaimProcessCode;
import com.himart.backend.claim.dao.ClaimDao;
import com.himart.backend.claim.dto.ClaimDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
@RequiredArgsConstructor
@Log4j2
public class ClaimValidator {

    private final ClaimDao claimDao;

    public void isValid(ClaimDto claimDto) {
        try{
            isValidStatus(claimDto);
        }catch (Exception e){
            log.debug(e.getMessage());
        }
    }

    //TODO 간결하게 정리하기
    private void isValidStatus(ClaimDto claimDto) throws Exception {
        ClaimProcessCode code = claimDao.getCurrentClaimProcessCode(claimDto);

        ClaimProcessCode currentStatus = ClaimProcessCode.DC;
        ClaimValidStatus validStatus = ClaimValidStatus.valueOf(claimDto.getClaimType().name());
        if(validStatus.isContains(currentStatus)) return;
        throw new Exception("클레임 가능 상태가 아닙니다");
    }
}

