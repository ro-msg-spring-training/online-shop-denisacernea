package ro.msg.learning.shop.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.msg.learning.shop.dto.SupplierDto;
import ro.msg.learning.shop.mapper.SupplierMapper;
import ro.msg.learning.shop.repository.SupplierRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;


    @Transactional
    public List<SupplierDto> getSupplierDtos(){
        return supplierRepository.findAll().stream().map(p -> new SupplierMapper().toSupplierDto(p)).collect(
            Collectors.toList());
    }

}
