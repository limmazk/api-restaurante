package br.com.limmazk.restaurante_api.mapper;

import br.com.limmazk.restaurante_api.dto.ClientRequestDTO;
import br.com.limmazk.restaurante_api.dto.ClientResponseDTO;
import br.com.limmazk.restaurante_api.model.Client;

public class ClientMapper {

    public static Client toEntity(ClientRequestDTO clientRequestDTO){

        Client client = new Client();

        client.setName(clientRequestDTO.name());
        client.setEmail(clientRequestDTO.email());
        client.setAddress(clientRequestDTO.address());
        client.setPhone(clientRequestDTO.phone());

        return client;
    }

    public static ClientResponseDTO toResponseDTO(Client client){
        return new ClientResponseDTO(
                client.getId(),
                client.getName(),
                client.getEmail(),
                client.getAddress(),
                client.getPhone()
        );
    }

    public static void updateEntity(ClientRequestDTO dto, Client client) {
        client.setName(dto.name());
        client.setEmail(dto.email());
        client.setAddress(dto.address());
        client.setPhone(dto.phone());
    }
}
