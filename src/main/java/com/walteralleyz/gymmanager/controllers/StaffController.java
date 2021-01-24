package com.walteralleyz.gymmanager.controllers;

import com.walteralleyz.gymmanager.dto.request.StaffDTO;
import com.walteralleyz.gymmanager.dto.response.MessageResponse;
import com.walteralleyz.gymmanager.exceptions.StaffNotFoundException;
import com.walteralleyz.gymmanager.services.StaffService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/admin/staff")
@AllArgsConstructor
public class StaffController {
    @Autowired
    private final StaffService staffService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponse create(@RequestBody @Valid StaffDTO staffDTO) {
        return staffRoutine(staffService.create(staffDTO), "created");
    }

    @GetMapping
    public List<StaffDTO> findAll() {
        return staffService.findAll();
    }

    @GetMapping("/{id}")
    public StaffDTO findById(@PathVariable Long id) throws StaffNotFoundException {
        return staffService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MessageResponse update(@PathVariable Long id, @RequestBody @Valid StaffDTO staffDTO) throws StaffNotFoundException {
        return staffRoutine(staffService.update(id, staffDTO), "updated");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponse delete(@PathVariable Long id) throws StaffNotFoundException {
        return staffRoutine(staffService.delete(id), "deleted");
    }

    public MessageResponse staffRoutine(String operation, String type) {
        return new MessageResponse(operation, type);
    }
}
