package com.cg.go.service;

import java.util.List;
import com.cg.go.entity.SalesReportEntity;
import com.cg.go.exception.SalesReportException;

public interface ISalesReportService {

	List<SalesReportEntity> findAllSalesReport();

	SalesReportEntity findSalesReportByProductId(String productId);

	void updateProductReport(SalesReportEntity salesReportEntity);

	void deleteAllSalesReport() throws SalesReportException;

	void deleteSalesReportById(Long salesReportId) throws SalesReportException;

}
