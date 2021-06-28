package com.cts.sparemanagement_product.repository;

import com.cts.sparemanagement_product.entity.FeedBackEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeedBackRepository extends JpaRepository<FeedBackEntitiy , Integer> {

    @Query(value ="SELECT feedback_rating , user_name FROM sparemanagement.feed_back_entitiy where product_id = ?" , nativeQuery = true)
    List<String> findByProductId(int productId);

}
