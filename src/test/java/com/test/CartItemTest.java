
package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.cg.go.entity.CartItemEntity;
import com.cg.go.entity.ProductEntity;
import com.cg.go.service.CartServiceImpl;
import com.cg.go.service.ICartService;
import com.cg.go.service.IProductService;
import com.cg.go.service.ProductServiceImpl;

public class CartItemTest {

	public static void main(String[] args) throws Exception{
		ICartService CartItemService=new CartServiceImpl();
		IProductService productService=new ProductServiceImpl();
		ProductEntity productEntity=new ProductEntity("123","Santoor",52.0,"mummy","orange","soap",2,"wipro","moisturizing soap");
		productService.addProduct(productEntity);
		List<ProductEntity> list=productService.findAllProducts();
		Map<ProductEntity,Integer> products=new HashMap<ProductEntity,Integer>();
		for(ProductEntity l:list) {
			products.put(l,l.getQuantity());
		}
		System.out.println(products+"Intial Products");
		CartItemEntity firstCartItemEntity=new CartItemEntity(456,"70",products,507,10);
		CartItemEntity secondCartItemEntity=new CartItemEntity(762,"79",products,549,7);
		
		CartItemService.addCart(firstCartItemEntity);
		CartItemService.addCart(secondCartItemEntity);
		//List<CartItemEntity> list1=CartItemService.findCartlist("78");
		//System.out.println(list1.get(0).getCartId());
		CartItemService.deleteCartlist(null);
		System.out.println(firstCartItemEntity.getProducts());
		System.out.println("Added Successfully");
		
	}
}