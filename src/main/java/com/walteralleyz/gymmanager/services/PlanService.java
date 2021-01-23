package com.walteralleyz.gymmanager.services;

import com.walteralleyz.gymmanager.entities.Plan;
import com.walteralleyz.gymmanager.exceptions.PlanNotFoundException;
import com.walteralleyz.gymmanager.repositories.PlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class PlanService {
    private final PlanRepository planRepository;

    public String create(Plan plan) {
        Plan planCreated = planRepository.save(plan);

        return "Plano criado com sucesso";
    }

    public String delete(Long id) throws PlanNotFoundException {
        planRepository.findById(id)
            .orElseThrow(PlanNotFoundException::new);

        planRepository.deleteById(id);

        return "Plano Deletado!";
    }

    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    public Plan findById(Long id) throws PlanNotFoundException {
        return planRepository.findById(id)
            .orElseThrow(PlanNotFoundException::new);
    }
}
