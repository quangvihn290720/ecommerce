package com.java.ecommerce.service;

import com.java.ecommerce.dto.request.CategoryCreationRequest;
import com.java.ecommerce.dto.response.CategoryResponse;
import com.java.ecommerce.entity.Category;
import com.java.ecommerce.exception.AppException;
import com.java.ecommerce.exception.ErrorCode;
import com.java.ecommerce.mapper.CategoryMapper;
import com.java.ecommerce.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryService {
    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;

    public CategoryResponse create(CategoryCreationRequest request){
        if (categoryRepository.existsById(String.valueOf(request.getId()))) {
            throw new AppException(ErrorCode.CATEGORY_EXISTED);
        }
        Category category = categoryMapper.toCategory(request);
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    public CategoryResponse getCategory(String id){
        return categoryMapper.toCategoryResponse(categoryRepository.findById(id)
                .orElseThrow(()-> new AppException(ErrorCode.CATEGORY_NOT_EXISTED)));
    }

    public List<CategoryResponse> getAllCategory(){
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toCategoryResponse).toList();
    }
}
