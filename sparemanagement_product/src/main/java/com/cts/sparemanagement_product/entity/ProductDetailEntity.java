package com.cts.sparemanagement_product.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
public class ProductDetailEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    @NotBlank(message = "Product Name Is Mandatory")
    private String productName;
    @NotNull(message = "Must have Some Quantity")
    private int productQuantity ;
    @NotNull(message = "Price of the Product is missing")
    private int productPrice;
    private Date productadded;

}
