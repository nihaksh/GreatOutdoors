
package com.cg.go.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.go.dao.CartRepositoryImpl;
import com.cg.go.dao.ICartRepository;
import com.cg.go.entity.CartItemEntity;
import com.cg.go.exception.CartException;

import util.JpaUtil;

public class CartServiceImpl implements ICartService{
	private EntityManager entityManager;
	private ICartRepository daoCart;

	public CartServiceImpl(){
		entityManager=JpaUtil.getInstance().getEntityManager();
		daoCart=new CartRepositoryImpl(entityManager);
	}

	public CartServiceImpl(EntityManager entityManager){
		this.entityManager=entityManager;
		this.daoCart=new CartRepositoryImpl(entityManager);
	}

	public List<CartItemEntity> findCartlist(String userId){
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<CartItemEntity> list=daoCart.findCartlist(userId);
        transaction.commit();
		return list;
	}
	
	public CartItemEntity addCart(CartItemEntity cartItemEntity) {
		 
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		try{
			if(cartItemEntity==null) {
				throw new CartException("IncorrectInput");
			}
	        CartItemEntity cartObject=daoCart.addCart(cartItemEntity);
	        transaction.commit();
			return cartObject;
		}
		catch(CartException cartException) {
			System.out.println(cartException.getMessage());
			transaction.commit();
		}
		return new CartItemEntity();//null
	}
	
	public CartItemEntity updateCart(CartItemEntity cartItemEntity){
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
        	if(cartItemEntity==null) {
				throw new CartException("IncorrectInput");
			}
	        CartItemEntity cartObject=daoCart.updateCart(cartItemEntity);
	        transaction.commit();
			return cartObject;
        }
        catch(CartException cartException) {
			System.out.println(cartException.getMessage());
			transaction.commit();
		}
		return new CartItemEntity();//null
	}
	

	public void deleteCartlist(String userId) {
		
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
	        	List<CartItemEntity> cartlist=daoCart.findCartlist(userId);
	        	if(cartlist.isEmpty()) {
	        		throw new CartException("UserId not found");
	        	}
				 daoCart.deleteCartlist(userId);
				 transaction.commit();
        	}
        catch(CartException cartException) {
			System.out.println(cartException.getMessage());
			transaction.commit();
		}
	}
	
	
	
	
	
	
	public CartItemEntity findCartItem(String productId, String userId) {
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        CartItemEntity cartObject=daoCart.findCartItem(productId,userId);
        transaction.commit();
		return cartObject;
	}
	
	public void deleteCartItem(Long cartId,String productId) {
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try{
				
	        daoCart.deleteCartItem(cartId,productId);
	        transaction.commit();
        }
        catch(CartException cartException) {
			System.out.println(cartException.getMessage());
			transaction.commit();
		}
	}
}
