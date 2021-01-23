package com.walteralleyz.gymmanager.controllers;

import com.walteralleyz.gymmanager.dto.request.ClientDTO;
import com.walteralleyz.gymmanager.exceptions.ClientNotFoundException;
import com.walteralleyz.gymmanager.services.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody @Valid ClientDTO clientDTO) {
        return clientService.create(clientDTO);
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
    public String delete(@PathVariable Long id) throws ClientNotFoundException {
        return clientService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String update(@PathVariable Long id, ClientDTO clientDTO) throws ClientNotFoundException {
        return clientService.update(id, clientDTO);
    }
}
