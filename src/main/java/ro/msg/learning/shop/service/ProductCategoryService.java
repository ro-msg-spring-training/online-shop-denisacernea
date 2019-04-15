package ro.msg.learning.shop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.msg.learning.shop.dto.ProductCategoryDto;
import ro.msg.learning.shop.mapper.ProductCategoryMapper;
import ro.msg.learning.shop.repository.ProductCategoryRepository;


import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;


    @Transactional
    public List<ProductCategoryDto> getProductCategoryDtos(){
        return productCategoryRepository.findAll().stream().map(p -> new ProductCategoryMapper().toProductCategoryDto(p)).collect(
            Collectors.toList());
    }

}
