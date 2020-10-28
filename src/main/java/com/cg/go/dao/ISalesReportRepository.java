
package com.cg.go.dao;
import com.cg.go.entity.SalesReportEntity;

public interface ISalesReportRepository {
	void updateProductReport(String productId,Integer quantity,double totalSale);
	boolean existsByProductId(String productId);
	SalesReportEntity findByProductId(String productId);
}
