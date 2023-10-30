package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Client;
import by.pvt.fooddelivery.dto.ClientRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface ClientMapper {
    Client toClient(ClientRequestDTO clientRequestDTO);

    ClientRequestDTO toDTO(Client client);
}
