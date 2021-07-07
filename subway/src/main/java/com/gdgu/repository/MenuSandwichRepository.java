package com.gdgu.repository;

import com.gdgu.entity.MenuSandwich;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuSandwichRepository extends CrudRepository<MenuSandwich, Long> {
    
}
