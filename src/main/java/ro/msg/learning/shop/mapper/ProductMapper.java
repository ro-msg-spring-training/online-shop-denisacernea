package ro.msg.learning.shop.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.repository.ProductCategoryRepository;
import ro.msg.learning.shop.repository.SupplierRepository;

@Component
@AllArgsConstructor
public class ProductMapper {

    private final ProductCategoryRepository productCategoryRepository;
    private final SupplierRepository supplierRepository;

    public Product toProduct(ProductDto productDto){
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setWeight(product.getWeight());
        product.setProductCategory(productCategoryRepository.findById(productDto.getProductCategoryId()).orElse(null));
        product.setSupplier(supplierRepository.findById(productDto.getSupplierId()).orElse(null));
        return product;
    }

    public ProductDto toProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setWeight(product.getWeight());
        productDto.setSupplier(product.getSupplier());
        productDto.setProductCategory(product.getProductCategory());
        return productDto;
    }
}
