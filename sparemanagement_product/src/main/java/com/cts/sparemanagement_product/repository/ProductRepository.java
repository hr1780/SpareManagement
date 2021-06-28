package com.cts.sparemanagement_product.repository;

import com.cts.sparemanagement_product.entity.ProductDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProductRepository extends JpaRepository<ProductDetailEntity , Integer> {


    @Query(value = "SELECT * FROM sparemanagement.product_detail_entity order by productadded desc limit 1", nativeQuery = true)
    public ProductDetailEntity findNewProduct();
}
