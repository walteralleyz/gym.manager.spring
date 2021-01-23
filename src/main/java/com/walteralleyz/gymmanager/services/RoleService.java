package com.walteralleyz.gymmanager.services;

import com.walteralleyz.gymmanager.entities.Role;
import com.walteralleyz.gymmanager.exceptions.RoleNotFoundException;
import com.walteralleyz.gymmanager.repositories.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public String create(Role role) {
        roleRepository.save(role);

        return "Role criado!";
    }

    public Role findById(Long id) throws RoleNotFoundException {
        return roleRepository.findById(id)
            .orElseThrow(() -> new RoleNotFoundException(id));
    }

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public String delete(Long id) throws RoleNotFoundException {
        roleRepository.findById(id)
            .orElseThrow(() -> new RoleNotFoundException(id));

        roleRepository.deleteById(id);

        return "Role deletado com sucesso!";
    }

    public String update(Long id, Role role) throws RoleNotFoundException {
        roleRepository.findById(id)
            .orElseThrow(() -> new RoleNotFoundException(id));

        roleRepository.save(role);

        return "Role atualizado.";
    }
}
