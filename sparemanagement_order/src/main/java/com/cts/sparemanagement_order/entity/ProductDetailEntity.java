package com.cts.sparemanagement_order.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
public class ProductDetailEntity {

    @Id
    private int productId;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private int productQuantity ;
    @Column(nullable = false)
    private int productPrice;
    @Column(nullable = false)
    private Date productadded;
}
