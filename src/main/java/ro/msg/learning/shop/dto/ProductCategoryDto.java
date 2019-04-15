package ro.msg.learning.shop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductCategoryDto {
    private Integer id;
    private String name;
    private String description;
}
