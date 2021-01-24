package com.walteralleyz.gymmanager.controllers;

import com.walteralleyz.gymmanager.dto.mapper.ClientMapper;
import com.walteralleyz.gymmanager.dto.request.ClientDTO;
import com.walteralleyz.gymmanager.dto.response.MessageResponse;
import com.walteralleyz.gymmanager.entities.Client;
import com.walteralleyz.gymmanager.exceptions.ClientNotFoundException;
import com.walteralleyz.gymmanager.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @PostMapping
    public ResponseEntity<ClientDTO> create(@RequestBody @Valid ClientDTO clientDTO) {
        Client client = clientService.create(clientDTO);

        return new ResponseEntity<>(clientMapper.toDTO(client), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ClientDTO> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable Long id) throws ClientNotFoundException {
        return clientService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponse delete(@PathVariable Long id) throws ClientNotFoundException {
        return clientRoutine(clientService.delete(id), "deleted");
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponse update(@PathVariable Long id, @RequestBody @Valid ClientDTO clientDTO) throws ClientNotFoundException {
        return clientRoutine(clientService.update(id, clientDTO), "updated");
    }

    public MessageResponse clientRoutine(String operation, String type) {
        return new MessageResponse(operation, type);
    }
}
