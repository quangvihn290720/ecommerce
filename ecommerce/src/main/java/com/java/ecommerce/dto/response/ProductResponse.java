package com.java.ecommerce.dto.response;

import com.java.ecommerce.entity.Brand;
import com.java.ecommerce.entity.Category;
import com.java.ecommerce.entity.Type;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {
    Long id;
    String code;
    String name;
    String description;
    Category category;
    Type type;
    Brand brand;
}
