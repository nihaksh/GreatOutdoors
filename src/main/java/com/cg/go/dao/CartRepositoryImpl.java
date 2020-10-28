
package com.cg.go.dao;


import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cg.go.entity.CartItemEntity;
import com.cg.go.exception.CartException;

public class CartRepositoryImpl implements ICartRepository{
	private EntityManager entityManager;

	public CartRepositoryImpl(EntityManager entityManager){
     this.entityManager=entityManager;
	}
	public List<CartItemEntity> findCartlist(String userId){
		List<CartItemEntity> list=entityManager.createQuery(" from CartItemEntity where userId=:userId",CartItemEntity.class).setParameter("userId", userId).getResultList();
		return list;
	}
	
	public CartItemEntity addCart(CartItemEntity cartItemEntity) throws CartException{
		if(cartItemEntity==null) {
			throw new CartException("Could not add again because already added to cart");
		}
		else {
			entityManager.persist(cartItemEntity);
			return cartItemEntity;
		}
	}
	public CartItemEntity updateCart(CartItemEntity cartItemEntity) throws CartException{

			entityManager.merge(cartItemEntity);
			return cartItemEntity;
	}
	
	public void deleteCartlist(String userId) throws CartException{

		if(userId==null) {
			throw new CartException("Not found in the cart");
		}
			Query query=entityManager.createQuery(" delete from CartItemEntity where userId=:userId",CartItemEntity.class).setParameter("userId", userId);
			query.executeUpdate();
	}
	
	
	
	
	public CartItemEntity findCartItem(String productId, String userId) {
		//ToDo
		return null;
	}
	public void deleteCartItem(Long cartId,String productId) throws CartException{
		/*CartItemEntity cartItem=entityManager.find(CartItemEntity.class,cartId,productId);
		if(cartItem==null) {
			throw new CartException("Not found in the cart");
		}
		else {
			entityManager.remove(cartItemEntity);
			
		}*/
	}

	
}
	
