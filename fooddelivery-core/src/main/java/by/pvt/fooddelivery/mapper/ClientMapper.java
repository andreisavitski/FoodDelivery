package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Client;
import by.pvt.fooddelivery.dto.ClientDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface ClientMapper {
    Client toClient(ClientDTO clientDTO);

    ClientDTO toDTO(Client client);
}
