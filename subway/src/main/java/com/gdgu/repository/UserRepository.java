package com.gdgu.repository;

import com.gdgu.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>  {
    public User findByUsername(String username);
    public boolean existsByUsername(String username);
}
