package com.cts.sparemanagement_order;

import com.cts.sparemanagement_order.repository.OrderRepository;
import com.cts.sparemanagement_order.controller.OrderController;
import com.cts.sparemanagement_order.entity.OrderDetailEntity;
import com.cts.sparemanagement_order.serviceinterface.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;


@SpringBootTest
class SparemanagementOrderApplicationTests {

	@MockBean
	OrderRepository orderRepository;

	@Autowired
	OrderService orderService;

	@Autowired
	OrderController orderController;

	private OrderDetailEntity mockOrder(){
		OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
		orderDetailEntity.setOrderId(100);
		orderDetailEntity.setProductName("Laptop");
		orderDetailEntity.setProductQuantity(1);
		orderDetailEntity.setOrderStatus("Shipped");
		orderDetailEntity.setInvoiceDate(new Date(Calendar.getInstance().getTime().getTime()));
		orderDetailEntity.setProductId("1");
		return orderDetailEntity;
	}



	@Test
	 void findOrderByIdTest(){
		when(orderRepository.findById(100)).thenReturn(Optional.of(mockOrder()));
		assertEquals(mockOrder().getOrderId(), orderService.findOrderById(100).get().getOrderId());
	}

	@Test
	 void changeOrderStatusTest(){
		when(orderRepository.findById(100)).thenReturn(Optional.of(mockOrder()));
		assertEquals("Order Status Change To InTransit" , orderService.changeOrderStatus(100 , "InTransit"));
	}

	@Test
	 void changeOrderStatus2Test(){
		when(orderRepository.findById(100)).thenReturn(Optional.of(mockOrder()));
		assertEquals("Order Status Change To Delivered" , orderService.changeOrderStatus(100 , "Delivered"));
	}

	@Test
	 void viewAllOrderTest(){
		when(orderRepository.findAll()).thenReturn(List.of(mockOrder()));
		assertEquals(List.of(mockOrder()).size() , orderService.viewAllOrder().size());
	}

}
