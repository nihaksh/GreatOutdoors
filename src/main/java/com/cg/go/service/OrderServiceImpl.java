package com.cg.go.service;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.go.dao.IOrderRepository;
import com.cg.go.dao.OrderRepositoryImpl;
import com.cg.go.entity.OrderEntity;
import com.cg.go.exception.OrderException;

import util.JpaUtil;

public class OrderServiceImpl implements IOrderService {
    private EntityManager entityManager;
    private IOrderRepository daoOrder;

    public OrderServiceImpl(EntityManager entityManager){
        this.entityManager=entityManager;
        daoOrder=new OrderRepositoryImpl(entityManager);
    }

    public OrderServiceImpl(){
        this.entityManager=JpaUtil.getInstance().getEntityManager();
        daoOrder=new OrderRepositoryImpl(entityManager);
    }

    public List<OrderEntity> findOrdersByUserId(String userId) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<OrderEntity> list = daoOrder.findOrdersByUserId(userId);
        transaction.commit();
        return list;
    }

    public List<OrderEntity> findAllOrders() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<OrderEntity> list = daoOrder.findAllOrders();
        transaction.commit();
        return list;
    }

    public OrderEntity addOrder(OrderEntity orderEntity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            List<OrderEntity> orderlist = daoOrder.findAllOrders();
            if (orderlist.isEmpty()) {
                throw new OrderException("UserId not found");
            }
            OrderEntity order = daoOrder.addOrder(orderEntity);
            return order;
        } catch (OrderException orderException) {
            System.out.println(orderException.getMessage());
            transaction.commit();
        }
        transaction.commit();
        return new OrderEntity();
    }

    public void deleteAllOrders() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            List<OrderEntity> orderlist = daoOrder.findAllOrders();
            if (orderlist.isEmpty()) {
                throw new OrderException("No Order in the list to delete");
            }
            daoOrder.deleteAllOrders();
            transaction.commit();

        } catch (OrderException orderException) {
            System.out.println(orderException.getMessage());
            transaction.commit();
        }

        transaction.commit();

    }

    public void deleteOrderById(String orderId) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            OrderEntity orderEntity = entityManager.find(OrderEntity.class, orderId);
            if (orderEntity == null) {
                throw new OrderException("OrderId not found");
            }
            daoOrder.deleteOrderById(orderId);
        } catch (OrderException orderException) {
            System.out.println(orderException.getMessage());
            transaction.commit();
        }
        transaction.commit();
    }


    public void updateDate(String orderId, LocalDate dispatchDate, LocalDate arrivalDate) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            OrderEntity orderEntity = entityManager.find(OrderEntity.class, orderId);
            if (orderEntity == null) {
                throw new OrderException("OrderId not found");
            }
            daoOrder.updateDate(orderId, dispatchDate, arrivalDate);
        } catch (OrderException orderException) {
            System.out.println(orderException.getMessage());
            transaction.commit();
        }
        transaction.commit();
    }

}
