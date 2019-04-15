package ro.msg.learning.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.learning.shop.model.ProductCategory;
import ro.msg.learning.shop.model.Supplier;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private double weight;
    private Integer productCategoryId;
    private Integer supplierId;

    private ProductCategory productCategory;
    private Supplier supplier;
}
