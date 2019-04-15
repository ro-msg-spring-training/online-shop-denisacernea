package ro.msg.learning.shop.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.msg.learning.shop.dto.SupplierDto;
import ro.msg.learning.shop.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
@AllArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping
    List<SupplierDto> getSuppliers() {
        return supplierService.getSupplierDtos();
    }

}
