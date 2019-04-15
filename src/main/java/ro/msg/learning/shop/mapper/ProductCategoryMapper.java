package ro.msg.learning.shop.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductCategoryDto;
import ro.msg.learning.shop.model.ProductCategory;

@Component
@AllArgsConstructor
public class ProductCategoryMapper {

    public ProductCategory toProductCategory(ProductCategoryDto productCategoryDto){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(productCategoryDto.getName());
        productCategory.setDescription(productCategoryDto.getDescription());
        return productCategory;
    }

    public ProductCategoryDto toProductCategoryDto(ProductCategory productCategory){
        ProductCategoryDto productCategoryDto = new ProductCategoryDto();
        productCategoryDto.setId(productCategory.getId());
        productCategoryDto.setName(productCategory.getName());
        productCategoryDto.setDescription(productCategory.getDescription());
        return productCategoryDto;
    }
}
