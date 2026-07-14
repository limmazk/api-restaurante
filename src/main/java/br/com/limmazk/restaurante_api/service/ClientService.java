package br.com.limmazk.restaurante_api.service;

import br.com.limmazk.restaurante_api.dto.ClientRequestDTO;
import br.com.limmazk.restaurante_api.dto.ClientResponseDTO;
import br.com.limmazk.restaurante_api.exception.ResourceNotFoundException;
import br.com.limmazk.restaurante_api.mapper.ClientMapper;
import br.com.limmazk.restaurante_api.model.Client;
import br.com.limmazk.restaurante_api.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<ClientResponseDTO> getAll(){
        List<Client> clients = clientRepository.findAll();

        return clients.stream()
                .map(ClientMapper::toResponseDTO)
                .toList();
    }

    public ClientResponseDTO getById(UUID id){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found."));
        return ClientMapper.toResponseDTO(client);
    }

    public ClientResponseDTO create(ClientRequestDTO dto){
        Client client = ClientMapper.toEntity(dto);
        Client clientSaved = clientRepository.save(client);
        return ClientMapper.toResponseDTO(clientSaved);
    }

    public ClientResponseDTO update(UUID id, ClientRequestDTO dto){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found."));

        ClientMapper.updateEntity(dto, client);
        clientRepository.save(client);
        return ClientMapper.toResponseDTO(client);
    }

    public void delete(UUID id){
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found."));
        clientRepository.delete(client);
    }
}
