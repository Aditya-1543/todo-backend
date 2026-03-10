package com.todo_backend.todo_backend.auth.repositories;

import com.todo_backend.todo_backend.auth.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRole(String role);
}