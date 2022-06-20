package com.himart.backend.claim.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LogDto <T, U>{

    private T insertData;
    private U updateData;

}
