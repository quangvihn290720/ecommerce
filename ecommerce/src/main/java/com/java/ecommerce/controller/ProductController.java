package com.java.ecommerce.controller;

import com.java.ecommerce.dto.request.ProductCreationRequest;
import com.java.ecommerce.dto.request.ProductUpdateRequest;
import com.java.ecommerce.dto.response.ApiResponse;
import com.java.ecommerce.dto.response.ProductResponse;
import com.java.ecommerce.service.ProductService;
import jakarta.validation.Valid;
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
@RequestMapping("/products")
@CrossOrigin("http://localhost:3000")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {
    ProductService productService;

    @GetMapping
    ApiResponse<Page<ProductResponse>> getAllProductsPagination(Pageable pageable){
        return ApiResponse.<Page<ProductResponse>>builder()
                .result(productService.getAllProductsPagination(pageable))
                .build();
    }

    @GetMapping("/{code}")
    ApiResponse<ProductResponse> getProduct(@PathVariable("code") String code){
        return ApiResponse.<ProductResponse>builder()
                .result(productService.getProduct(code))
                .build();
    }

    @PostMapping
    ApiResponse<ProductResponse> create(@Valid @RequestBody ProductCreationRequest request){
        return ApiResponse.<ProductResponse>builder()
                .result(productService.create(request))
                .build();
    }

    @PutMapping("/{code}")
    ApiResponse<ProductResponse> update(@PathVariable("code") String code,
                                        @Valid @RequestBody ProductUpdateRequest request){
        return ApiResponse.<ProductResponse>builder()
                .result(productService.update(code, request))
                .build();
    }

    @DeleteMapping("/{code}")
    ApiResponse<String> delete(@PathVariable("code") String code){
        productService.delete(code);
        return ApiResponse.<String>builder()
                .result("Product with code "+ code + " has been deleted")
                .build();
    }
}
