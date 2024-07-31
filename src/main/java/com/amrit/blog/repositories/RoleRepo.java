package com.amrit.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amrit.blog.entities.Role;

public interface RoleRepo  extends JpaRepository<Role, Integer>{

}
