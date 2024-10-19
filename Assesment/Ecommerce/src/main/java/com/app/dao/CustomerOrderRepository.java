package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.CustomerOrder;

public interface CustomerOrderRepository extends JpaRepository<CustomerOrder,Long> {

}
