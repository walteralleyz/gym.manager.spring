package com.walteralleyz.gymmanager.repositories;

import com.walteralleyz.gymmanager.entities.Plan;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PlanRepository extends JpaRepository<Plan, Long> {
}
