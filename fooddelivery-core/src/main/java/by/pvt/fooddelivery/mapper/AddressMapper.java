package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.entity.Address;
import by.pvt.fooddelivery.dto.AddressDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toAddress(AddressDTO addressDTO);

    AddressDTO toDTO(Address address);
}
