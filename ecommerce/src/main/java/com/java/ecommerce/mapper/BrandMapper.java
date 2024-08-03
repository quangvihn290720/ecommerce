package com.java.ecommerce.mapper;

import com.java.ecommerce.dto.request.BrandCreationRequest;
import com.java.ecommerce.dto.request.BrandUpdateRequest;
import com.java.ecommerce.dto.response.BrandResponse;
import com.java.ecommerce.entity.Brand;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    Brand toBrand(BrandCreationRequest request);

    BrandResponse toBrandResponse(Brand brand);

    void updateBrand(@MappingTarget Brand brand, BrandUpdateRequest request);
}
