package com.anil.tech.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anil.tech.order.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

}
