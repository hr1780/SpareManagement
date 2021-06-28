package com.cts.sparemanagement_order.repository;

import com.cts.sparemanagement_order.entity.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductDetailEntity , Integer> {
}
