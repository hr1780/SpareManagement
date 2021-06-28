package com.cts.sparemanagement_product.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class FeedBackEntitiy {

    @Id
    @GeneratedValue
    int feedbackId;
    @NotNull(message = "Product Id is missing")
    int productId;
    @NotNull(message = "FeedBack is missing")
    int feedbackRating ;
    @NotBlank(message = "UserName is Missing")
    String userName;

}
