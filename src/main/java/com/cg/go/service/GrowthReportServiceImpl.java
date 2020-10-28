package com.cg.go.service;

import java.util.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.cg.go.entity.*;
import com.cg.go.exception.*;

import util.JpaUtil;

import com.cg.go.dao.*;

public class GrowthReportServiceImpl implements IGrowthReportService{
	EntityManager entityManager;
	IGrowthReportRepository daoGrowthReport;

	public GrowthReportServiceImpl(EntityManager entityManager){
		this.entityManager=entityManager;
		this.daoGrowthReport=new GrowthReportRepositoryImpl(entityManager);
	}

	public GrowthReportServiceImpl(){
		entityManager=JpaUtil.getInstance().getEntityManager();
		this.daoGrowthReport=new GrowthReportRepositoryImpl(entityManager);
	}

    public List<GrowthReportEntity> findAllGrowthReport(){
    	EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<GrowthReportEntity> list=daoGrowthReport.findAllGrowthReport();
        transaction.commit();
        return list;
		
	}
	public void addGrowthReport() throws SalesReportException{
		EntityTransaction transaction = entityManager.getTransaction();
	    transaction.begin();
	    daoGrowthReport.addGrowthReport();
	    transaction.commit();
	    
	}
	public void deleteAllGrowthReport() throws GrowthReportException{
		EntityTransaction transaction = entityManager.getTransaction();
	    transaction.begin();
	    daoGrowthReport.deleteAllGrowthReport();
	    transaction.commit();
	}
	public void deleteGrowthReportById(Long growthReportId) throws GrowthReportException{
		EntityTransaction transaction = entityManager.getTransaction();
	    transaction.begin();
	    daoGrowthReport.deleteAllGrowthReport();
	    transaction.commit();
	}
}
