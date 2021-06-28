package com.cts.sparemanagement_order.entity;
import lombok.Data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Data
public class OrderDetailEntity {

    @Id
    @GeneratedValue
    private int orderId;
    @NotBlank(message = "Product id is missing")
    private String productId;
    @NotBlank(message = "Product Name is Missing")
    private String productName;
    @NotNull(message = "Product Quntity is missing")
    private int productQuantity;
    private Date invoiceDate;
    @NotBlank(message = "Order Status is missing")
    private String orderStatus;


}
