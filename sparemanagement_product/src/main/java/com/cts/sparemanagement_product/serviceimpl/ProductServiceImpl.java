package com.cts.sparemanagement_product.serviceimpl;

import com.cts.sparemanagement_product.service.ProductService;
import com.cts.sparemanagement_product.entity.FeedBackEntitiy;
import com.cts.sparemanagement_product.entity.ProductDetailEntity;
import com.cts.sparemanagement_product.exception.ProductNotFoundException;
import com.cts.sparemanagement_product.repository.FeedBackRepository;
import com.cts.sparemanagement_product.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    FeedBackRepository feedBackRepository;

    public String addProduct(ProductDetailEntity detailEntity){
        log.info("Into the add product service method ");
        detailEntity.setProductadded(new Date(Calendar.getInstance().getTime().getTime()));
        productRepository.save(detailEntity);
       return  "Your Product has Been  Added \n Product Id : " + detailEntity.getProductId()  ;
    }


    public ProductDetailEntity viewNewProduct(){

        log.info("Into the view new product");
      return  productRepository.findNewProduct();

    }

    public ProductDetailEntity changeProductDetail(ProductDetailEntity detailEntity , int productId)throws ProductNotFoundException{
        log.info("Into the change product detail service");
        Optional<ProductDetailEntity> optionalProductDetailEntity = productRepository.findById(productId);
        if (optionalProductDetailEntity.isPresent()){
            log.info("The Product is present in the database");
            ProductDetailEntity productDetailEntity = optionalProductDetailEntity.get();
            productDetailEntity.setProductPrice(detailEntity.getProductPrice());
            productDetailEntity.setProductQuantity(detailEntity.getProductQuantity());
            return productRepository.save(productDetailEntity);
        }else {
            log.warn("No product with such product name ");
            throw new ProductNotFoundException("There is no product with product id : "+ productId);
        }
    }


    public List<String> showfeedBack(int productId){

        log.info("Into the showfeedback service method");
         return feedBackRepository.findByProductId(productId);
    }

    public String feedBack(int productId , int rating, String username){
        log.info("Into the feedback service method");
        if(productRepository.findById(productId).isPresent()){
          FeedBackEntitiy feedBackEntitiy = new FeedBackEntitiy();
          feedBackEntitiy.setProductId(productId);
          feedBackEntitiy.setFeedbackRating(rating);
          feedBackEntitiy.setUserName(username);
          feedBackRepository.save(feedBackEntitiy);

          return  "Your Rating has been Saved ";
        }
        else{
            return "No Such Product";
        }
    }
    public List<ProductDetailEntity> showAllProducts (){

        log.info("INto the  show all product method");

        return  productRepository.findAll();
    }
}
