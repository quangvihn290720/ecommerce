package com.java.ecommerce.controller;

import com.java.ecommerce.dto.response.ApiResponse;
import com.java.ecommerce.dto.response.BrandResponse;
import com.java.ecommerce.service.BrandService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/brands")
@CrossOrigin("http://localhost:3000")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BrandController {
    BrandService brandService;

    @GetMapping("/{id}")
    ApiResponse<BrandResponse> getBrand(@PathVariable("id") String id){
        return ApiResponse.<BrandResponse>builder()
                .result(brandService.getBrand(id))
                .build();
    }

    @GetMapping
    ApiResponse<List<BrandResponse>> getAllBrand(){
        return ApiResponse.<List<BrandResponse>>builder()
                .result(brandService.getAllBrand())
                .build();
    }
}
