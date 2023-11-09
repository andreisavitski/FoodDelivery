package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Client;
import by.pvt.fooddelivery.dto.ClientRequest;
import by.pvt.fooddelivery.dto.ClientResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface ClientMapper {
    @Mapping(source = "addressDTO", target = "address")
    Client toClient(ClientRequest clientRequest);

    @Mapping(source = "addressDTO", target = "address")
    Client toClient(ClientResponse clientResponse);

    @Mapping(source = "address", target = "addressDTO")
    ClientResponse toDTO(Client client);
}
