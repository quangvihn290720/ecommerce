package com.java.ecommerce.mapper;

import com.java.ecommerce.dto.request.TypeCreationRequest;
import com.java.ecommerce.dto.request.TypeUpdateRequest;
import com.java.ecommerce.dto.response.TypeResponse;
import com.java.ecommerce.entity.Type;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface TypeMapper {

    Type toType(TypeCreationRequest request);

    TypeResponse toTypeResponse(Type type);

    void updateType(@MappingTarget Type type, TypeUpdateRequest request);
}
