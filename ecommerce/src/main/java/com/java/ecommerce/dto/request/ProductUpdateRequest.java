package com.java.ecommerce.dto.request;

import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductUpdateRequest {
    @Size(min = 6, message = "PRODUCT_NAME_INVALID")
    String name;
    String description;

    String categoryId;
    String typeId;
    String brandId;
}
