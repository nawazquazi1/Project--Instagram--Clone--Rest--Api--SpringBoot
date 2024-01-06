package com.instagram.clone.restApi.repositories;

import com.instagram.clone.restApi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
}
