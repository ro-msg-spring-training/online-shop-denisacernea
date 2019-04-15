package ro.msg.learning.shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.ProductCategoryDto;
import ro.msg.learning.shop.service.ProductCategoryService;

import java.util.List;

@RestController
@RequestMapping("/productCategories")
@AllArgsConstructor
public class ProductCategoryController {

    private final ProductCategoryService productCategoryService;

    @GetMapping
    List<ProductCategoryDto> getProductCategories() {
        return productCategoryService.getProductCategoryDtos();
    }

}
