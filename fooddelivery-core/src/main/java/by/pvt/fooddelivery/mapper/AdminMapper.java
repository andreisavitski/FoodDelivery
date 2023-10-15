package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Admin;
import by.pvt.fooddelivery.dto.AdminDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    AdminDTO toDTO(Admin admin);

    Admin toAdmin(AdminDTO adminDTO);
}
