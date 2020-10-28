package com.cg.go.entity;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Map;
import java.util.Objects;

@Entity
public class CartItemEntity {
	@Id
	private long cartId;
	private String userId;
	@ElementCollection
	private Map<ProductEntity, Integer> products ;// product ,quantity
	private double cartTotalPrice;
	private long totalQuantity;
	public CartItemEntity(long cartId, String userId, Map<ProductEntity, Integer> products, double cartTotalPrice,
			long totalQuantity) {
		this.cartId = cartId;
		this.userId = userId;
		this.products = products;
		this.cartTotalPrice = cartTotalPrice;
		this.totalQuantity = totalQuantity;
	}
	public CartItemEntity() {
		 
	}
	public long getCartId() {
		return cartId;
	}
	public void setCartId(long cartId) {
		this.cartId = cartId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Map<ProductEntity, Integer> getProducts() {
		return products;
	}
	public void setProducts(Map<ProductEntity, Integer> products) {
		this.products = products;
	}
	public double getCartTotalPrice() {
		return cartTotalPrice;
	}
	public void setCartTotalPrice(double cartTotalPrice) {
		this.cartTotalPrice = cartTotalPrice;
	}
	public long getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	@Override
	public int hashCode() {
		int hash=Objects.hashCode(cartId);
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItemEntity other = (CartItemEntity) obj;
		if (cartId != other.cartId)
			return false;
		return true;
	}
}
