package com.cg.go.dao;

import javax.persistence.EntityManager;

import com.cg.go.entity.OrderEntity;
import com.cg.go.entity.SalesReportEntity;

public class SalesReportRepositoryImpl implements ISalesReportRepository{
	private EntityManager entityManager;
	public SalesReportRepositoryImpl(EntityManager entityManager){
     this.entityManager=entityManager;
	}
	public void updateProductReport(String productId,Integer quantity,double totalSale) {
		SalesReportEntity salesReportEntity=(SalesReportEntity) entityManager.createQuery("select s from SalesReportEntity s ").getSingleResult();
		if(salesReportEntity==null) {
			entityManager.persist(new SalesReportEntity());
		}
			
		entityManager.merge(salesReportEntity);
		
	}
	public boolean existsByProductId(String productId) {
		SalesReportEntity salesReportEntity=entityManager.find(SalesReportEntity.class,productId);
		if(salesReportEntity==null)
			return false;
		return true;
	}
	public SalesReportEntity findByProductId(String productId) {
		SalesReportEntity salesReportEntity=entityManager.find(SalesReportEntity.class,productId);
		return salesReportEntity;
	}
}