package com.himart.backend.category.controller;

import com.himart.backend.category.dto.HierarchyDispCateDto;
import com.himart.backend.category.service.DispCateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cate")
public class DispCateController {

    private final DispCateService dispCateService;

    @GetMapping("/dispCate")
    List<HierarchyDispCateDto> getDispCateList(){
        return dispCateService.getDispCateList();
    }
}
