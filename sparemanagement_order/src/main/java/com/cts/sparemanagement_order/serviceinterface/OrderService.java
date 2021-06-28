package com.cts.sparemanagement_order.serviceinterface;

import com.cts.sparemanagement_order.entity.OrderDetailEntity;
import com.cts.sparemanagement_order.exception.ProductNotFoundException;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    public OrderDetailEntity createOrder(OrderDetailEntity orderDetailEntity)throws ProductNotFoundException;
    public Optional<OrderDetailEntity> findOrderById(int orderId);
    public String changeOrderStatus(int orderId , String orderStatus);
    public List<OrderDetailEntity> viewAllOrder();

}
