package com.gdgu.repository;

import com.gdgu.entity.OrderForm;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderFormRepository extends CrudRepository<OrderForm, Long>{
    
}
