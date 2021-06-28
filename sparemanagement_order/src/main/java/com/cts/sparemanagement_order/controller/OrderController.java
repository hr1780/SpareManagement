package com.cts.sparemanagement_order.controller;

import com.cts.sparemanagement_order.entity.OrderDetailEntity;
import com.cts.sparemanagement_order.exception.ProductNotFoundException;
import com.cts.sparemanagement_order.serviceinterface.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class OrderController {

    @Autowired
    OrderService orderService;


    @Value("${spring.application.name:no name}")
    private String appName;

    @Value("${server.port:no port}")
    private String port;

    @GetMapping("/location")
    public String getRegesterServiceLocation(){
        log.info("into the location controller ");
        return appName + " : " + port;
    }

    @PostMapping("orders/order")
    public ResponseEntity<OrderDetailEntity> createOrder(@Valid  @RequestBody OrderDetailEntity orderDetailEntity )throws ProductNotFoundException {
        log.info("Into the create order controller");
            return  new ResponseEntity<>(orderService.createOrder(orderDetailEntity), HttpStatus.CREATED);
    }

    @GetMapping("order/{orderId}")
    public ResponseEntity<OrderDetailEntity> viewOrderById(@PathVariable int orderId){
        log.info("Into the view order by Id controller");
        return new ResponseEntity<>(orderService.findOrderById(orderId).get(), HttpStatus.OK);
    }

    @PutMapping("order/{orderId}")
    public ResponseEntity<String> changeOrderStatus (@PathVariable int orderId, @RequestParam String orderStatus){
        log.info("into the change order status controller");
        return new ResponseEntity<>(orderService.changeOrderStatus(orderId , orderStatus), HttpStatus.OK);
    }

    @GetMapping("order/orders")
    public ResponseEntity<List<OrderDetailEntity>> viewAllOrdertest() {
        log.info("into the view all order controller ");
        return new ResponseEntity<>(orderService.viewAllOrder(), HttpStatus.OK);
    }

    @GetMapping("/logout")
    public void logout(final HttpSecurity httpSecurity) throws Exception{
        httpSecurity.logout().invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

    }

}
