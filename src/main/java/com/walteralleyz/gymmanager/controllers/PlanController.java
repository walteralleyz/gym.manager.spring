package com.walteralleyz.gymmanager.controllers;

import com.walteralleyz.gymmanager.dto.response.MessageResponse;
import com.walteralleyz.gymmanager.entities.Plan;
import com.walteralleyz.gymmanager.exceptions.PlanNotFoundException;
import com.walteralleyz.gymmanager.services.PlanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Plan> create(@RequestBody @Valid Plan plan) {
        Plan newPlan = planService.create(plan);
        return ResponseEntity.ok(newPlan);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plan> findById(@PathVariable Long id) throws PlanNotFoundException {
        return ResponseEntity.ok(planService.findById(id));
    }

    @GetMapping
    public List<Plan> findAll() {
        return planService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponse delete(@PathVariable("id") Long id) throws PlanNotFoundException {
        return planRoutine(planService.delete(id), "deleted");
    }

    public MessageResponse planRoutine(String operation, String type) {
        return new MessageResponse(operation, type);
    }
}
