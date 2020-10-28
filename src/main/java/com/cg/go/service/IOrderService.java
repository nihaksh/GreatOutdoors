package com.cg.go.service;

import java.time.LocalDate;
import java.util.List;
import com.cg.go.entity.OrderEntity;
import com.cg.go.exception.OrderException;

public interface IOrderService {

	public List<OrderEntity> findOrdersByUserId(String userId);

	public List<OrderEntity> findAllOrders();

	public OrderEntity addOrder(OrderEntity orderEntity) throws OrderException;

	public void deleteAllOrders() throws OrderException;

	public void deleteOrderById(String orderId) throws OrderException;

	public void updateDate(String orderId, LocalDate dispatchDate, LocalDate arrivalDate) throws OrderException;

}
