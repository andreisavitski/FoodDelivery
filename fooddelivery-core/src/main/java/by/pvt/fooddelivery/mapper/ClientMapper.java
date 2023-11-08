package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Client;
import by.pvt.fooddelivery.dto.ClientRequest;
import by.pvt.fooddelivery.dto.ClientResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface ClientMapper {
    Client toClient(ClientRequest clientRequest);

    Client toClient(ClientResponse clientResponse);

    ClientResponse toDTO(Client client);
}
