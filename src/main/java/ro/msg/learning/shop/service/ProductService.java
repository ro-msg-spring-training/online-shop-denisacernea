package ro.msg.learning.shop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.exceptions.NullProductException;
import ro.msg.learning.shop.mapper.ProductMapper;
import ro.msg.learning.shop.model.Product;
import ro.msg.learning.shop.model.ProductCategory;
import ro.msg.learning.shop.model.Supplier;
import ro.msg.learning.shop.repository.ProductCategoryRepository;
import ro.msg.learning.shop.repository.ProductRepository;
import ro.msg.learning.shop.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;
    private final ProductCategoryRepository productCategoryRepository;


    @Transactional
    public List<ProductDto> getProductDtos(){
        return productRepository.findAll().stream().map(p -> new ProductMapper(productCategoryRepository, supplierRepository).toProductDto(p)).collect(
            Collectors.toList());
    }

    @Transactional
    public ProductDto getProductDto(Integer id){
        Product product = productRepository.findById(id).orElseThrow(() -> new NullProductException(id));
        return new ProductMapper(productCategoryRepository, supplierRepository).toProductDto(product);
    }

    @Transactional
    public ProductDto createProduct(ProductDto productDto){
        Product product = productRepository.save(new ProductMapper(productCategoryRepository, supplierRepository).toProduct(productDto));
        return new ProductMapper(productCategoryRepository, supplierRepository).toProductDto(product);
    }

    @Transactional
    public ProductDto changeProduct(ProductDto productDto){
        Product product = productRepository.findById(productDto.getId()).orElseThrow(() -> new NullProductException(productDto.getId()));

        if (productDto.getName()!= null && !product.getName().equals(productDto.getName())){
            product.setName(productDto.getName());
        }

        if (!product.getDescription().equals(productDto.getDescription())){
            product.setDescription(productDto.getDescription());
        }

        if (!product.getPrice().equals(productDto.getPrice())){
            product.setPrice(productDto.getPrice());
        }

        if (product.getWeight()!= productDto.getWeight()){
            product.setWeight(productDto.getWeight());
        }

        if (productDto.getProductCategoryId()!= null) {
            Optional<ProductCategory> productCategory = productCategoryRepository.findById(productDto.getProductCategoryId());
            if (productCategory.isPresent()) {
                product.setProductCategory(productCategory.get());
            }
        }

        if (productDto.getSupplierId()!= null ){
            Optional<Supplier> supplier = supplierRepository.findById(productDto.getSupplierId());
            if (supplier.isPresent()){
                product.setSupplier(supplier.get());
            }
        }

        Product changedProduct = productRepository.save(product);

        return new ProductMapper(productCategoryRepository, supplierRepository).toProductDto(changedProduct);
    }


    @Transactional
    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }
}
