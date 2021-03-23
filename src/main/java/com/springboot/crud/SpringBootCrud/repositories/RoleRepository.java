package com.springboot.crud.SpringBootCrud.repositories;

import com.springboot.crud.SpringBootCrud.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
