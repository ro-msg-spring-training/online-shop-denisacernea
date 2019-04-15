package ro.msg.learning.shop.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dto.SupplierDto;
import ro.msg.learning.shop.model.Supplier;

@Component
@AllArgsConstructor
public class SupplierMapper {

    public Supplier toSupplier(SupplierDto supplierDto){
        Supplier supplier = new Supplier();
        supplier.setName(supplierDto.getName());
        return supplier;
    }

    public SupplierDto toSupplierDto(Supplier supplier){
        SupplierDto supplierDto = new SupplierDto();
        supplierDto.setId(supplier.getId());
        supplierDto.setName(supplier.getName());
        return supplierDto;
    }
}
