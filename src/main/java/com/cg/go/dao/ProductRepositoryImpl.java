package com.cg.go.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.cg.go.entity.ProductEntity;
import com.cg.go.exception.ProductException;

public class ProductRepositoryImpl implements IProductRepository{

	private EntityManager entityManager;

	public ProductRepositoryImpl(EntityManager entityManager){
     this.entityManager=entityManager;
	}
	
	
	public List<ProductEntity> findAllProducts(){
		List<ProductEntity> list=new ArrayList<ProductEntity>();
		list=entityManager.createQuery("select a from ProductEntity a",ProductEntity.class).getResultList();
		return list;
	}
	
	public ProductEntity findByProductId(String id) {
		ProductEntity productEntity=entityManager.find(ProductEntity.class,id);
		return productEntity;
	}

	public List<ProductEntity> findByProductCategory(String productCategory){
		List<ProductEntity> list=new ArrayList<ProductEntity>();
		list=entityManager.createQuery("select a from ProductEntity a where category=:'productCategory'",ProductEntity.class).setParameter("productCategory",productCategory).getResultList();
		return list;
	}

	public ProductEntity addProduct(ProductEntity productEntity) throws ProductException{
		if(productEntity==null) {
			throw new ProductException("productEntity already added/exists");
		}
		entityManager.persist(productEntity);
		return productEntity;
		
	}

	public ProductEntity updateProduct(ProductEntity productEntity) throws ProductException{
		if(productEntity==null) {
			throw new ProductException("Invalid Input");
		}
		else {
				entityManager.merge(productEntity);
				return productEntity;
			}
	}

	public void updateProductQuantity(Integer quantity,String productId) {
		ProductEntity productEntity=entityManager.find(ProductEntity.class,productId);
		productEntity.setQuantity(quantity);
	}

	public void deleteByProductId(String id) throws ProductException{
		ProductEntity productEntity=entityManager.find(ProductEntity.class,id);
		if(productEntity==null) {
			throw new ProductException("productEntity not found so cannot be deleted");
		}
		entityManager.remove(productEntity);

	}

	public List<ProductEntity> search(String keyword){
		List<ProductEntity> list=new ArrayList<ProductEntity>();
		list=entityManager.createQuery("select a from ProductEntity a where productName='productName'",ProductEntity.class).setParameter("productName",keyword).getResultList();
		return list;
	}

	public List<ProductEntity> filter(double maxPrice){
		List<ProductEntity> list=new ArrayList<ProductEntity>();
		list=entityManager.createQuery("select a from ProductEntity a where price<='maxPrice'",ProductEntity.class).setParameter("maxPrice",maxPrice).getResultList();
		return list;
	}
}