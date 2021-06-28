package com.cts.sparemanagement_product.service;

import com.cts.sparemanagement_product.entity.ProductDetailEntity;
import com.cts.sparemanagement_product.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    public abstract String addProduct(ProductDetailEntity detailEntity);
    public abstract ProductDetailEntity viewNewProduct();
    public abstract ProductDetailEntity changeProductDetail(ProductDetailEntity detailEntity , int productId) throws ProductNotFoundException;
    public abstract List<String> showfeedBack(int productId);
    public abstract String feedBack(int productId , int rating, String username);
    public abstract List<ProductDetailEntity> showAllProducts();

}
