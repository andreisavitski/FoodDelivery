package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Client;
import by.pvt.fooddelivery.dto.ClientRequestDTO;
import by.pvt.fooddelivery.dto.ClientResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface ClientMapper {
    Client toClient(ClientRequestDTO clientRequestDTO);

    ClientResponseDTO toDTO(Client client);
}
