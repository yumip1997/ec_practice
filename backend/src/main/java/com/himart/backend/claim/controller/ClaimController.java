package com.himart.backend.claim.controller;

import com.himart.backend.claim.dto.ClaimDto;
import com.himart.backend.claim.service.ClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ClaimController {

    private final ClaimService claimService;

    @PostMapping("/claim")
    public void claim(@RequestBody ClaimDto claimDto) throws Exception {
        claimService.claim(claimDto);
    }
}
