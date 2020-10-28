
package com.cg.go.dao;

import java.util.List;

import com.cg.go.entity.GrowthReportEntity;
import com.cg.go.exception.GrowthReportException;
import com.cg.go.exception.SalesReportException;

public interface IGrowthReportRepository{
	List<GrowthReportEntity> findAllGrowthReport();

	void addGrowthReport() throws SalesReportException;

	void deleteAllGrowthReport() throws GrowthReportException;

	void deleteGrowthReportById(Long growthReportId) throws GrowthReportException;
}
