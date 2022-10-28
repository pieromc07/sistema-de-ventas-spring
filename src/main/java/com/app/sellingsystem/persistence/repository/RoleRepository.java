package com.app.sellingsystem.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.sellingsystem.persistence.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByDescription(String description);
    boolean existsByDescription(String description);
}
