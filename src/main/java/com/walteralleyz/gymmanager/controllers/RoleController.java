package com.walteralleyz.gymmanager.controllers;

import com.walteralleyz.gymmanager.dto.response.MessageResponse;
import com.walteralleyz.gymmanager.entities.Role;
import com.walteralleyz.gymmanager.exceptions.RoleNotFoundException;
import com.walteralleyz.gymmanager.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/roles")
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse create(@RequestBody @Valid Role role) {
        return roleRoutine(roleService.create(role), "created");
    }

    @GetMapping
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public Role findById(@PathVariable Long id) throws RoleNotFoundException {
        return roleService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MessageResponse update(@PathVariable Long id, @RequestBody @Valid Role role) throws RoleNotFoundException {
        return roleRoutine(roleService.update(id, role), "updated");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponse delete(@PathVariable Long id) throws RoleNotFoundException {
        return roleRoutine(roleService.delete(id), "deleted");
    }

    public MessageResponse roleRoutine(String operation, String type) {
        return new MessageResponse(operation, type);
    }
}
