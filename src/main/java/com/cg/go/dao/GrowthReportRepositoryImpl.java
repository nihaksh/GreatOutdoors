package com.cg.go.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.cg.go.entity.Customer;
import com.cg.go.entity.GrowthReportEntity;
import com.cg.go.exception.GrowthReportException;
import com.cg.go.exception.ProductException;
import com.cg.go.exception.SalesReportException;

public class GrowthReportRepositoryImpl implements IGrowthReportRepository{
	private EntityManager entityManager;

	public GrowthReportRepositoryImpl(EntityManager entityManager){
     this.entityManager=entityManager;
	}
	public List<GrowthReportEntity> findAllGrowthReport(){
		List<GrowthReportEntity> list=new ArrayList<GrowthReportEntity>();
		list=entityManager.createQuery("select a from GrowthReportEntity a",GrowthReportEntity.class).getResultList();
		return list;
	}
	public void addGrowthReport() throws SalesReportException{
		/*if(growthReportEntity==null) {
			throw new GrowthReportException("growthReportEntity not found");
		}
		else {
			entityManager.persist(growthReportEntity);
		}*/
		//ToDo
		
	}

	public void deleteAllGrowthReport() throws GrowthReportException{
		//ToDo
		Query query=entityManager.createQuery("delete from GrowthReportEntity");
		query.executeUpdate();
	}

	public void deleteGrowthReportById(Long growthReportId) throws GrowthReportException{
		GrowthReportEntity growthReportEntity=entityManager.find(GrowthReportEntity.class,growthReportId);
		if(growthReportEntity==null) {
			throw new GrowthReportException("growthReportEntity not found");
		}
		else {
			entityManager.remove(growthReportEntity);
		}
	}
}