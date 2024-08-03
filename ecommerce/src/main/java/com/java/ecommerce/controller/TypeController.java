package com.java.ecommerce.controller;

import com.java.ecommerce.dto.response.ApiResponse;
import com.java.ecommerce.dto.response.TypeResponse;
import com.java.ecommerce.service.TypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/types")
@CrossOrigin("http://localhost:3000")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TypeController {
    TypeService typeService;

    @GetMapping("/{id}")
    ApiResponse<TypeResponse> getType(@PathVariable("id") String id){
        return ApiResponse.<TypeResponse>builder()
                .result(typeService.getType(id))
                .build();
    }

    @GetMapping
    ApiResponse<List<TypeResponse>> getAllType(){
        return ApiResponse.<List<TypeResponse>>builder()
                .result(typeService.getAllType())
                .build();
    }
}
