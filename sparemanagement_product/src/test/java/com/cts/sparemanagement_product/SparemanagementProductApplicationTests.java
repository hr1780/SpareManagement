package com.cts.sparemanagement_product;

import com.cts.sparemanagement_product.service.ProductService;
import com.cts.sparemanagement_product.entity.FeedBackEntitiy;
import com.cts.sparemanagement_product.entity.ProductDetailEntity;
import com.cts.sparemanagement_product.exception.ProductNotFoundException;
import com.cts.sparemanagement_product.repository.FeedBackRepository;
import com.cts.sparemanagement_product.repository.ProductRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class  SparemanagementProductApplicationTests {


	@MockBean
	ProductRepository productRepository;
	@Autowired
	ProductService productService;
	@MockBean
	FeedBackRepository feedBackRepository;

	public ProductDetailEntity mockProductDetailEntity(){
		ProductDetailEntity productDetailEntity = new ProductDetailEntity();

		productDetailEntity.setProductId(1);
		productDetailEntity.setProductName("card");
		productDetailEntity.setProductPrice(10);
		productDetailEntity.setProductQuantity(20);
		productDetailEntity.setProductadded(new Date(2017-12-01));

		return productDetailEntity;
	}

	public FeedBackEntitiy mockFeedBackEntity(){
		FeedBackEntitiy feedBackEntitiy = new FeedBackEntitiy();
		feedBackEntitiy.setProductId(2);
		feedBackEntitiy.setFeedbackRating(5);
		feedBackEntitiy.setFeedbackId(5);
		feedBackEntitiy.setUserName("hr431");

		return feedBackEntitiy;
	}

	@Test
	public void addProductTest(){
		when(productRepository.save(mockProductDetailEntity())).thenReturn(mockProductDetailEntity());
		System.out.print(productService.addProduct(mockProductDetailEntity()));
		assertEquals("Your Product has Been  Added \n Product Id : 1", productService.addProduct(mockProductDetailEntity()));
	}
	

	@Test(expected = ProductNotFoundException.class)
	public void changeProductDetailFailTest() throws ProductNotFoundException {
		productService.changeProductDetail(mockProductDetailEntity(), 7);
		when(productRepository.findById(7)).thenThrow(new ProductNotFoundException(""));
	}

	@Test
	public  void showfeedBackTest(){
		when(feedBackRepository.findByProductId(2)).thenReturn(List.of("5" ,"hr431"));
		assertEquals(List.of("5" ,"hr431"), productService.showfeedBack(2));
	}

	@Test
	public void addFeedbackFailTest(){
		when(feedBackRepository.findByProductId(2)).thenReturn(List.of("5" ,"hr431"));
		assertEquals("No Such Product", productService.feedBack(2 , 3 , "hr421"));
	}

	@Test
	public void showAllProductsTest(){
		when(productRepository.findAll()).thenReturn(List.of(mockProductDetailEntity()));
		assertEquals(List.of(mockProductDetailEntity()), productService.showAllProducts());
	}


}
