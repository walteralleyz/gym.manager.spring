package com.walteralleyz.gymmanager.services;

import com.walteralleyz.gymmanager.dto.request.ClientDTO;
import com.walteralleyz.gymmanager.dto.mapper.ClientMapper;
import com.walteralleyz.gymmanager.entities.Client;
import com.walteralleyz.gymmanager.exceptions.ClientNotFoundException;
import com.walteralleyz.gymmanager.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public Client create(ClientDTO clientDTO) {
        Client client = clientMapper.toModel(clientDTO);

        return clientRepository.save(client);
    }

    public List<ClientDTO> findAll() {
        return clientRepository.findAll().stream()
            .map(clientMapper::toDTO)
            .collect(Collectors.toList());
    }

    public ClientDTO findById(Long id) throws ClientNotFoundException {
        return clientMapper.toDTO(clientRepository.findById(id)
            .orElseThrow(ClientNotFoundException::new));
    }

    public String delete(Long id) throws ClientNotFoundException {
        clientRepository.findById(id)
            .orElseThrow(ClientNotFoundException::new);

        clientRepository.deleteById(id);

        return "Cliente apagado dos registros";
    }

    public String update(Long id, ClientDTO clientDTO) throws ClientNotFoundException {
        clientRepository.findById(id)
            .orElseThrow(ClientNotFoundException::new);

        Client client = clientMapper.toModel(clientDTO);

        clientRepository.save(client);

        return "Cadastro atualizado com sucesso!";
    }
}
