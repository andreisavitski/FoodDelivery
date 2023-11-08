package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Admin;
import by.pvt.fooddelivery.dto.AdminRequest;
import by.pvt.fooddelivery.dto.AdminResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    AdminResponse toDTO(Admin admin);

    Admin toAdmin(AdminRequest adminRequest);

    Admin toAdmin(AdminResponse adminResponse);
}
