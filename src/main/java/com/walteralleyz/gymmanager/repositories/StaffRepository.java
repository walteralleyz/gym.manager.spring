package com.walteralleyz.gymmanager.repositories;

import com.walteralleyz.gymmanager.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {
    public Staff findByUsername(String username);
}
