package com.cg.go.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cg.go.entity.OrderEntity;
import com.cg.go.exception.OrderException;

public class OrderRepositoryImpl implements IOrderRepository{
	private EntityManager entityManager;

	public OrderRepositoryImpl(EntityManager entityManager){
     this.entityManager=entityManager;
	}
	public List<OrderEntity> findOrdersByUserId(String userId){
		List<OrderEntity> list=new ArrayList<OrderEntity>();
		list=entityManager.createQuery("from OrderEntity where userId=:userId",OrderEntity.class).setParameter("userId", userId).getResultList();
		return list;
	}
	public List<OrderEntity> findAllOrders(){
		List<OrderEntity> list=new ArrayList<OrderEntity>();
		list=entityManager.createQuery("from OrderEntity",OrderEntity.class).getResultList();
		return list;
	}
	public OrderEntity addOrder(OrderEntity orderEntity) throws OrderException{	
		if(orderEntity==null) {
			throw new OrderException("OrderEntity not found");
		}
		else {
				entityManager.persist(orderEntity);
				return orderEntity;
		}
	}
	public void deleteAllOrders() throws OrderException{
		//ToDo
		Query query=entityManager.createQuery("delete from OrderEntity");
		query.executeUpdate();
	}
	public void deleteOrderById(String orderId) throws OrderException{
		OrderEntity orderEntity=entityManager.find(OrderEntity.class,orderId);	
		if(orderEntity==null) {
			throw new OrderException("OrderEntity not found");
		}
		else {
				entityManager.remove(orderEntity);
			}
	}
	public void updateDate(String orderId, LocalDate dispatchDate, LocalDate arrivalDate) throws OrderException{
		OrderEntity orderEntity=entityManager.find(OrderEntity.class,orderId);	
		if(orderEntity==null) {
			throw new OrderException("OrderEntity not found");
		}
		else {
			orderEntity.setDispatchDate(dispatchDate);
			orderEntity.setDeliveryDate(arrivalDate);
		}
	}
}
