package com.test;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cg.go.entity.OrderEntity;
import com.cg.go.entity.ProductEntity;
import com.cg.go.exception.OrderException;
import com.cg.go.exception.ProductException;
import com.cg.go.service.IOrderService;
import com.cg.go.service.IProductService;
import com.cg.go.service.OrderServiceImpl;
import com.cg.go.service.ProductServiceImpl;

public class OrderItemTest {
	public static void main(String[] args) {
		IProductService productService=new ProductServiceImpl();
		IOrderService orderService=new OrderServiceImpl();
		LocalDate dispatchDate = LocalDate.of( 2015 , 6 , 7 );
		LocalDate localDate = LocalDate.of( 2017 , 6 , 7 );
		ProductEntity productEntity=new ProductEntity("123","Santoor",52.0,"mummy","orange","soap",2,"wipro","moisturizing soap");
		List<ProductEntity> list=new ArrayList<ProductEntity>();
		
		
		try{
			productService.addProduct(productEntity);
			list=productService.findAllProducts();
			Map<ProductEntity,Integer> products=new HashMap<ProductEntity,Integer>();
			for(ProductEntity l:list) {
				products.put(l,l.getQuantity());
			}
			OrderEntity orderEntity1=new OrderEntity("5","70",products,5,10l,localDate,dispatchDate);
			OrderEntity orderEntity2=new OrderEntity("12","70",products,5,10l,localDate,dispatchDate);
			orderService.addOrder(orderEntity1);
			//orderService.deleteAllOrders();
			orderService.addOrder(orderEntity2);
			orderService.deleteOrderById("12");
			System.out.println("orderid:"+orderEntity1.getOrderId());
			//orderService.updateDate("5",dispatchDate,localDate);*/
		}
		catch(ProductException productException) {
			System.out.println(productException.getStackTrace());
		}
		catch(OrderException orderException) {
			System.out.println(orderException.getStackTrace());
		}
		catch(Exception e) {
			System.out.println("Unknown exception occured");
		}
		}
}