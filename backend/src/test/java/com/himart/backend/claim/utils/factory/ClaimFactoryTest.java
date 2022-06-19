package com.himart.backend.claim.utils.factory;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.utils.creator.ClaimDataCreator;
import com.himart.backend.claim.utils.creator.impl.EcouponCancelAcceptDataCreator;
import com.himart.backend.claim.utils.creator.impl.GeneralCancelDataCreator;
import com.himart.backend.claim.utils.processor.ClaimProcessor;
import com.himart.backend.claim.utils.processor.impl.CommonProcessor;
import com.himart.backend.claim.utils.processor.impl.CompleteProcessor;
import com.himart.backend.claim.utils.validator.ClaimValidator;
import com.himart.backend.claim.utils.validator.impl.ClaimCommonValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//모든 빈을 Ioc 컨테이너에 등록한다.
@SpringBootTest
class ClaimFactoryTest {

    @Test
    @DisplayName("일반상품주문취소완료의")
    void general_prd_ordercanel_test(){
        //given
        String type = "GCC";

        //when
        ClaimProcessor claimProcessor = ClaimFactory.findClaimProcessor(type);
        ClaimDataCreator claimDataCreator = ClaimFactory.findClaimDataCreator(type);
        ClaimValidator claimValidator = ClaimFactory.findClaimValidator(type);

        //then
        Assertions.assertThat(claimProcessor).isInstanceOf(CompleteProcessor.class);
        Assertions.assertThat(claimDataCreator).isInstanceOf(GeneralCancelDataCreator.class);
        Assertions.assertThat(claimValidator).isInstanceOf(ClaimCommonValidator.class);
    }

    @Test
    @DisplayName("모바일쿠폰주문취소접수")
    void ecoupon_ordercanel_accept_test(){
        //given
        String type = "MCA";

        //when
        ClaimProcessor claimProcessor = ClaimFactory.findClaimProcessor(type);
        ClaimDataCreator claimDataCreator = ClaimFactory.findClaimDataCreator(type);
        ClaimValidator claimValidator = ClaimFactory.findClaimValidator(type);

        //then
        Assertions.assertThat(claimProcessor).isInstanceOf(CommonProcessor.class);
        Assertions.assertThat(claimDataCreator).isInstanceOf(EcouponCancelAcceptDataCreator.class);
        Assertions.assertThat(claimValidator).isInstanceOf(ClaimCommonValidator.class);
    }
}