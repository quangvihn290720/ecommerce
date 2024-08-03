package com.java.ecommerce.service;

import com.java.ecommerce.dto.response.BrandResponse;
import com.java.ecommerce.exception.AppException;
import com.java.ecommerce.exception.ErrorCode;
import com.java.ecommerce.mapper.BrandMapper;
import com.java.ecommerce.repository.BrandRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BrandService {
    BrandRepository brandRepository;
    BrandMapper brandMapper;

    public BrandResponse getBrand(String id){
        return brandMapper.toBrandResponse(brandRepository.findById(id)
                .orElseThrow(()-> new AppException(ErrorCode.BRAND_NOT_EXISTED)));
    }

    public List<BrandResponse> getAllBrand(){
        return brandRepository.findAll().stream()
                .map(brandMapper::toBrandResponse).toList();
    }
}
