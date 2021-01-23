package com.walteralleyz.gymmanager.controllers;

import com.walteralleyz.gymmanager.entities.Plan;
import com.walteralleyz.gymmanager.exceptions.PlanNotFoundException;
import com.walteralleyz.gymmanager.services.PlanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/planos")
@AllArgsConstructor
public class PlanController {
    private final PlanService planService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody @Valid Plan plan) {
        return planService.create(plan);
    }

    @GetMapping
    public List<Plan> findAll() {
        return planService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String delete(@PathVariable("id") Long id) throws PlanNotFoundException {
        return planService.delete(id);
    }
}
