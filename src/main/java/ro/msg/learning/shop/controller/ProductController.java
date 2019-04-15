package ro.msg.learning.shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.ProductDto;
import ro.msg.learning.shop.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    List<ProductDto> getProducts() {
        return productService.getProductDtos();
    }

    @PostMapping( produces = "application/json", consumes = "application/json")
    ProductDto createProduct(@RequestBody ProductDto newProductDto) {
        return productService.createProduct(newProductDto);
    }

    @GetMapping("/{id}")
    ProductDto getProduct(@PathVariable Integer id) {
        return productService.getProductDto(id);
    }

    @PostMapping(path = "/{id}", produces = "application/json", consumes = "application/json")
    ProductDto changeProduct(@RequestBody ProductDto newProductDto) {
        return productService.changeProduct(newProductDto);
    }

    @DeleteMapping("/{id}")
    void deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
    }
}
