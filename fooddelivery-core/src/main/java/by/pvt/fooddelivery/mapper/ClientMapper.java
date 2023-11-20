package by.pvt.fooddelivery.mapper;

import by.pvt.fooddelivery.domain.Client;
import by.pvt.fooddelivery.dto.ClientRequestDTO;
import by.pvt.fooddelivery.dto.ClientResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface ClientMapper {
    @Mapping(source = "addressDTO", target = "address")
    Client toClient(ClientRequestDTO clientRequestDTO);

    @Mapping(source = "addressDTO", target = "address")
    Client toClient(ClientResponseDTO clientResponseDTO);

    @Mapping(source = "address", target = "addressDTO")
    ClientResponseDTO toDTO(Client client);
}
