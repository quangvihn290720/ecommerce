package com.java.ecommerce.controller;

import com.java.ecommerce.dto.response.ApiResponse;
import com.java.ecommerce.dto.response.CategoryResponse;
import com.java.ecommerce.dto.response.ProductResponse;
import com.java.ecommerce.service.CategoryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
@CrossOrigin("http://localhost:3000")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryController {
    CategoryService categoryService;

    @GetMapping("/{id}")
    ApiResponse<CategoryResponse> getCategory(@PathVariable("id") String id){
        return ApiResponse.<CategoryResponse>builder()
                .result(categoryService.getCategory(id))
                .build();
    }

    @GetMapping
    ApiResponse<List<CategoryResponse>> getAllCategory(){
        return ApiResponse.<List<CategoryResponse>>builder()
                .result(categoryService.getAllCategory())
                .build();
    }
}
