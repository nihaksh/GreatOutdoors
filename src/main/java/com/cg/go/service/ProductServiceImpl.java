
package com.cg.go.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.go.dao.IProductRepository;
import com.cg.go.dao.ProductRepositoryImpl;
import com.cg.go.entity.ProductEntity;
import com.cg.go.exception.ProductException;

import util.JpaUtil;

public class ProductServiceImpl implements IProductService {

    EntityManager entityManager;

    IProductRepository daoProduct;

    public ProductServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.daoProduct = new ProductRepositoryImpl(entityManager);
    }

    public ProductServiceImpl() {
        this.entityManager = JpaUtil.getInstance().getEntityManager();
        this.daoProduct = new ProductRepositoryImpl(entityManager);
    }

    @Override
    public List<ProductEntity> findAllProducts() {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<ProductEntity> list = daoProduct.findAllProducts();
        transaction.commit();
        return list;

    }

    @Override
    public ProductEntity findByProductId(String id) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        ProductEntity productObject = daoProduct.findByProductId(id);
        transaction.commit();
        return productObject;
    }

    @Override
    public List<ProductEntity> findByProductCategory(String productCategory) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<ProductEntity> list = daoProduct.findByProductCategory(productCategory);
        transaction.commit();
        return list;

    }

    @Override
    public ProductEntity addProduct(ProductEntity productEntity) throws ProductException {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        ProductEntity productObject = daoProduct.addProduct(productEntity);
        transaction.commit();
        return productObject;
    }

    @Override
    public ProductEntity updateProduct(ProductEntity productEntity) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            ProductEntity productObject = daoProduct.updateProduct(productEntity);
            transaction.commit();
            return productObject;
        } catch (ProductException productException) {
            System.out.println(productException.getMessage());
            transaction.commit();
        }
        return new ProductEntity();//null
    }

    @Override
    public void updateProductQuantity(Integer quantity, String productId) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        daoProduct.updateProductQuantity(quantity, productId);
        transaction.commit();

    }

    @Override
    public void deleteByProductId(String id) throws ProductException {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        daoProduct.deleteByProductId(id);
        transaction.commit();
    }

    @Override
    public List<ProductEntity> search(String keyword) {
        List<ProductEntity> list = new ArrayList<ProductEntity>();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        list = daoProduct.search(keyword);
        transaction.commit();
        return list;
    }

    @Override
    public List<ProductEntity> filter(double maxPrice) {
        List<ProductEntity> list = new ArrayList<ProductEntity>();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        list = daoProduct.filter(maxPrice);
        transaction.commit();
        return list;
    }
}
