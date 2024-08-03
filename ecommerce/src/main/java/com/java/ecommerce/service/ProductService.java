package com.java.ecommerce.service;

import com.java.ecommerce.dto.request.ProductCreationRequest;
import com.java.ecommerce.dto.request.ProductUpdateRequest;
import com.java.ecommerce.dto.response.ProductResponse;
import com.java.ecommerce.entity.Brand;
import com.java.ecommerce.entity.Category;
import com.java.ecommerce.entity.Product;
import com.java.ecommerce.entity.Type;
import com.java.ecommerce.exception.AppException;
import com.java.ecommerce.exception.ErrorCode;
import com.java.ecommerce.mapper.ProductMapper;
import com.java.ecommerce.repository.BrandRepository;
import com.java.ecommerce.repository.CategoryRepository;
import com.java.ecommerce.repository.ProductRepository;
import com.java.ecommerce.repository.TypeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {
    CategoryRepository categoryRepository;
    TypeRepository typeRepository;
    BrandRepository brandRepository;
    ProductRepository productRepository;
    ProductMapper productMapper;

    public ProductResponse create(ProductCreationRequest request){
        if (productRepository.existsByCode(request.getCode())) {
            throw new AppException(ErrorCode.PRODUCT_EXISTED);
        }
        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow(()->
                new AppException(ErrorCode.CATEGORY_NOT_EXISTED));
        Type type = typeRepository.findById(request.getTypeId()).orElseThrow(()->
                new AppException(ErrorCode.TYPE_NOT_EXISTED));
        Brand brand = brandRepository.findById(request.getBrandId()).orElseThrow(()->
                new AppException(ErrorCode.BRAND_NOT_EXISTED));

        Product product = productMapper.toProduct(request);
        product.setCategory(category);
        product.setType(type);
        product.setBrand(brand);
        return productMapper.toProductResponse(productRepository.save(product));
    }

    public ProductResponse update(String code, ProductUpdateRequest request){
        Product product = productRepository.findProductByCode(code)
                .orElseThrow(()-> new AppException(ErrorCode.PRODUCT_NOT_EXISTED));
        Category category = categoryRepository.findById(request.getCategoryId()).orElseThrow(()->
                new AppException(ErrorCode.CATEGORY_NOT_EXISTED));
        Type type = typeRepository.findById(request.getTypeId()).orElseThrow(()->
                new AppException(ErrorCode.TYPE_NOT_EXISTED));
        Brand brand = brandRepository.findById(request.getBrandId()).orElseThrow(()->
                new AppException(ErrorCode.BRAND_NOT_EXISTED));

        productMapper.updateProduct(product, request);
        product.setCategory(category);
        product.setType(type);
        product.setBrand(brand);
        return productMapper.toProductResponse(productRepository.save(product));
    }

    public void delete(String code){
        Product product = productRepository.findProductByCode(code)
                .orElseThrow(()-> new AppException(ErrorCode.PRODUCT_NOT_EXISTED));
        productRepository.delete(product);
    }

    public ProductResponse getProduct(String code){
        return productMapper.toProductResponse(productRepository.findProductByCode(code)
                .orElseThrow(()-> new AppException(ErrorCode.PRODUCT_NOT_EXISTED)));
    }

    public List<ProductResponse> getProducts(){
        return productRepository.findAll().stream()
                .map(productMapper::toProductResponse).toList();
    }

    public Page<ProductResponse> getAllProductsPagination(Pageable pageable){
        Page<Product> productResponsePage = productRepository.findAll(pageable);
        List<Product> productList = productResponsePage.getContent();
        List<ProductResponse> productResponses = productList.stream().map(productMapper::toProductResponse).toList();
        return new PageImpl<ProductResponse>(productResponses,pageable,productResponsePage.getTotalElements());
    }

}
