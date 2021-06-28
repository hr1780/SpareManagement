package com.cts.sparemanagement_order.serviceimpl;

import com.cts.sparemanagement_order.repository.OrderRepository;
import com.cts.sparemanagement_order.repository.ProductRepository;
import com.cts.sparemanagement_order.repository.UserRepository;
import com.cts.sparemanagement_order.entity.OrderDetailEntity;
import com.cts.sparemanagement_order.entity.ProductDetailEntity;
import com.cts.sparemanagement_order.exception.ProductNotFoundException;
import com.cts.sparemanagement_order.serviceinterface.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    public OrderDetailEntity createOrder(OrderDetailEntity orderDetailEntity) throws ProductNotFoundException{
        if (productRepository.findById(Integer.parseInt(orderDetailEntity.getProductId())).isPresent()) {
            log.info("the product is available in the database");
            ProductDetailEntity productDetailEntity = productRepository.findById(Integer.parseInt(orderDetailEntity.getProductId())).get();
            if (productDetailEntity.getProductQuantity() >= (orderDetailEntity.getProductQuantity())) {
                log.info("Product quantity is sufficient");
                productDetailEntity.setProductQuantity(productDetailEntity.getProductQuantity() - orderDetailEntity.getProductQuantity());
                productRepository.save(productDetailEntity);
                orderDetailEntity.setInvoiceDate(new Date(Calendar.getInstance().getTime().getTime()));
                return orderRepository.save(orderDetailEntity);
            }
            else{
                log.warn("product is not available in sufficient Quantity ");
            }
        }
        throw new ProductNotFoundException("There is no product with product");
    }

    public Optional<OrderDetailEntity> findOrderById(int orderId){
        log.info("In to the find order by ide service method");
        return orderRepository.findById(orderId);
    }


    public String changeOrderStatus(int orderId , String orderStatus){
        log.info("Into the Change Order Status service method");
        if(orderRepository.findById(orderId).isPresent()){
            log.info("The Order ID is present ");
        OrderDetailEntity orderDetailEntity1 = orderRepository.findById(orderId).get();
            orderDetailEntity1.setOrderStatus(orderStatus);
        orderRepository.save(orderDetailEntity1);
        return "Order Status Change To " +orderStatus ;
        }
        else{
            return "No order Exits by order ID : " + orderId;
        }

    }


   public List<OrderDetailEntity> viewAllOrder() {
        log.info("Into the view all order service method");
        return  orderRepository.findAll();
   }

}
