package com.java.ecommerce.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCreationRequest {
    Long id;
    @Size(min = 4, message = "PRODUCT_CODE_INVALID")
    String code;
    String name;
    String description;
    String categoryId;
    String typeId;
    String brandId;
}
