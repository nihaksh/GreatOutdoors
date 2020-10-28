package com.cg.go.service;

import java.util.List;
import com.cg.go.entity.ProductEntity;
import com.cg.go.exception.ProductException;

public interface IProductService {

	List<ProductEntity> findAllProducts();

	ProductEntity findByProductId(String id);

	List<ProductEntity> findByProductCategory(String productCategory);

	ProductEntity addProduct(ProductEntity productEntity) throws ProductException;

	ProductEntity updateProduct(ProductEntity productEntity) throws ProductException;

	void updateProductQuantity(Integer quantity,String productId);

	void deleteByProductId(String id) throws ProductException;

	List<ProductEntity> search(String keyword);

	List<ProductEntity> filter(double maxPrice);

}
