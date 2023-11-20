package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Admin;
import by.pvt.fooddelivery.dto.AdminRequestDTO;
import by.pvt.fooddelivery.dto.AdminResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    AdminResponseDTO toDTO(Admin admin);

    Admin toAdmin(AdminRequestDTO adminRequestDTO);

    Admin toAdmin(AdminResponseDTO adminResponseDTO);
}
