package com.java.ecommerce.mapper;

import com.java.ecommerce.dto.request.ProductCreationRequest;
import com.java.ecommerce.dto.request.ProductUpdateRequest;
import com.java.ecommerce.dto.response.ProductResponse;
import com.java.ecommerce.entity.Product;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "request.categoryId", target = "category.id")
    @Mapping(source = "request.brandId", target = "brand.id")
    @Mapping(source = "request.typeId", target = "type.id")
    Product toProduct(ProductCreationRequest request);

    @Mapping(source = "product.category.id", target = "category.id")
    @Mapping(source = "product.brand.id", target = "brand.id")
    @Mapping(source = "product.type.id", target = "type.id")
    ProductResponse toProductResponse(Product product);

    void updateProduct(@MappingTarget Product product, ProductUpdateRequest request);
}
