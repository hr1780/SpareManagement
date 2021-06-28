package com.cts.sparemanagement_product.contoller;

import com.cts.sparemanagement_product.service.ProductService;
import com.cts.sparemanagement_product.entity.ProductDetailEntity;
import com.cts.sparemanagement_product.exception.ProductNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @Value("${spring.application.name:no name}")
    private String appName;

    @Value("${server.port:no port}")
    private String port;

    @GetMapping("/location")
    public String getProductServiceLocation(){

        log.info("Into the location Controller");
        return appName + " : " + port;
    }

    @PostMapping("/products")
    public ResponseEntity<String>addProduct(@Valid @RequestBody ProductDetailEntity detailEntity){
        log.info("Into the add product controller");
        return new ResponseEntity <>(productService.addProduct(detailEntity), HttpStatus.CREATED );
    }

    @GetMapping("/product/newproducts")
    public  ResponseEntity<ProductDetailEntity> viewNewProduct(){
        log.info("Into the view new product controller");
        return new ResponseEntity<>(productService.viewNewProduct(), HttpStatus.OK);
    }

    @PutMapping("/product/{productId}")
    public ResponseEntity<ProductDetailEntity> changeProductDetail(@RequestBody ProductDetailEntity detailEntity , @PathVariable int productId) throws ProductNotFoundException {
        log.info("Into the change product detail controller");
        return  new ResponseEntity<>(productService.changeProductDetail(detailEntity , productId), HttpStatus.CREATED);
    }

    @GetMapping("/product/products")
    public ResponseEntity<List<ProductDetailEntity>> showAllProducts(){
        log.info("Into the show all product controller");
        return new ResponseEntity<>(productService.showAllProducts(), HttpStatus.OK);
    }

    @PutMapping("/product/feedback/{productId}")
    public ResponseEntity<String> getFeedBack( @PathVariable int productId , @RequestParam int rating , @RequestParam String username){
        log.info("Into the get feedback controller");
        return new ResponseEntity<>(productService.feedBack(productId, rating, username), HttpStatus.OK);
    }

    @GetMapping("/product/feedback/{productId}")
    public ResponseEntity<List<String>> showFeedback(@PathVariable int productId){
        log.info("Into the show feedback controller");
        return new ResponseEntity<>(productService.showfeedBack(productId), HttpStatus.OK);
    }

    @GetMapping("/logout")
    public void logout(final HttpSecurity httpSecurity) throws Exception{
        httpSecurity.logout().invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

    }

}
