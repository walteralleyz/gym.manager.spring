package com.walteralleyz.gymmanager.dto.mapper;

import com.walteralleyz.gymmanager.dto.request.ClientDTO;
import com.walteralleyz.gymmanager.entities.Client;
import com.walteralleyz.gymmanager.exceptions.PlanNotFoundException;
import com.walteralleyz.gymmanager.services.PlanService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor(onConstructor_ = @Autowired)
public class ClientMapper {
    private final PlanService planService;

    public Client toModel(ClientDTO clientDTO) {
        Client client = new Client();

        client.setId(clientDTO.getId());
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        client.setCreatedAt(clientDTO.getCreated());
        client.setHeight(clientDTO.getHeight());
        client.setWeight(clientDTO.getWeight());
        client.setExpireTime(clientDTO.getExpires());

        try {
            client.setPlan(planService.findById(clientDTO.getPlanId()));
        } catch (PlanNotFoundException e) {
            System.out.println("Plano não encontrado!");

            try {
                client.setPlan(planService.findById(Long.parseLong("1")));
            } catch (PlanNotFoundException exc) {
                System.out.println("Algum erro ao procurar o plano!");
            }
        }

        return client;
    }

    public ClientDTO toDTO(Client client) {
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());
        clientDTO.setEmail(client.getEmail());
        clientDTO.setCreated(client.getCreatedAt());
        clientDTO.setExpires(client.getExpireTime());
        clientDTO.setHeight(client.getHeight());
        clientDTO.setWeight(client.getWeight());
        clientDTO.setPlanId(client.getPlan().getId());
        clientDTO.setPlan(client.getPlan());

        return clientDTO;
    }
}
