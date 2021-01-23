package com.walteralleyz.gymmanager.repositories;

import com.walteralleyz.gymmanager.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
