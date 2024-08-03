package com.java.ecommerce.mapper;

import com.java.ecommerce.dto.request.CategoryCreationRequest;
import com.java.ecommerce.dto.request.CategoryUpdateRequest;
import com.java.ecommerce.dto.response.CategoryResponse;
import com.java.ecommerce.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryCreationRequest request);

    CategoryResponse toCategoryResponse(Category category);

    void updateCategory(@MappingTarget Category brand, CategoryUpdateRequest request);
}
