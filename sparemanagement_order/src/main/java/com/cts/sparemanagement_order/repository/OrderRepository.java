package com.cts.sparemanagement_order.repository;

import com.cts.sparemanagement_order.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderDetailEntity , Integer> {
}
