package com.java.ecommerce.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),

    PRODUCT_EXISTED(2001, "Product existed", HttpStatus.BAD_REQUEST),
    PRODUCT_NOT_EXISTED(2002, "Product not existed", HttpStatus.NOT_FOUND),
    PRODUCT_CODE_INVALID(2003,"Product Code must be at least {min} characters", HttpStatus.BAD_REQUEST),
    PRODUCT_NAME_INVALID(2004,"Product Name must be at least {min} characters", HttpStatus.BAD_REQUEST),

    CATEGORY_EXISTED(3001, "Category existed", HttpStatus.BAD_REQUEST),
    CATEGORY_NOT_EXISTED(3002, "Category not existed", HttpStatus.NOT_FOUND),
    CATEGORY_NAME_INVALID(3004,"Category Name must be at least {min} characters", HttpStatus.BAD_REQUEST),

    BRAND_NOT_EXISTED(4002, "Brand not existed", HttpStatus.NOT_FOUND),
    BRAND_NAME_INVALID(4004,"Brand Name must be at least {min} characters", HttpStatus.BAD_REQUEST),

    TYPE_NOT_EXISTED(5002, "Product type not existed", HttpStatus.NOT_FOUND),
    TYPE_NAME_INVALID(5004,"Type Name must be at least {min} characters", HttpStatus.BAD_REQUEST),
    ;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;
}
