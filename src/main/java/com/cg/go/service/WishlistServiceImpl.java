package com.cg.go.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.go.dao.IWishlistRepository;
import com.cg.go.dao.WishlistRepositoryImpl;
import com.cg.go.entity.WishlistItemEntity;
import com.cg.go.exception.InvalidProductIdException;
import com.cg.go.exception.WishlistException;

import util.JpaUtil;

public class WishlistServiceImpl  implements IWishlistService{
	EntityManager entityManager;
	IWishlistRepository daoWishlist;

	public WishlistServiceImpl(EntityManager entityManager){
		this.entityManager=entityManager;
		this.daoWishlist=new WishlistRepositoryImpl(entityManager);
	}

	public WishlistServiceImpl(){
		entityManager=JpaUtil.getInstance().getEntityManager();
		this.daoWishlist=new WishlistRepositoryImpl(entityManager);
	}

     @Override
	public List<WishlistItemEntity> findAllItems() {
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<WishlistItemEntity> list=new ArrayList<WishlistItemEntity>();
        list=daoWishlist.findAllItems();
        transaction.commit();
		return list;
	}

	@Override
	public List<WishlistItemEntity> findWishlist(String userId) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<WishlistItemEntity> list=new ArrayList<WishlistItemEntity>();
        list=daoWishlist.findWishlist(userId);
        transaction.commit();
		return list;
	}

	@Override
	public WishlistItemEntity findWishlistItem(String productId, String userId) {
		EntityTransaction transaction = entityManager.getTransaction();
	    transaction.begin();
	    WishlistItemEntity wishlistObject =daoWishlist.findWishlistItem(productId,userId);
	    transaction.commit();
		return wishlistObject;
	}

	@Override
	public void addProductToWishlist(String prodId, long wishlistID) {
		if(prodId==null||prodId.isEmpty()){
         throw new InvalidProductIdException("productid is null or empty");
		}
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        daoWishlist.addProductToWishlist(prodId, wishlistID );
        transaction.commit();
      
		
	}

	@Override
	public void deleteWishlistItem(String productId, String userId) throws WishlistException {
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        daoWishlist.deleteWishlistItem(productId, userId);
        transaction.commit();
	}

	@Override
	public void deleteWishlist(String userId) throws WishlistException {
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        daoWishlist.deleteWishlist(userId);
        transaction.commit();
		
	}

	@Override
	public WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem) throws WishlistException {
		if(wishlistItem==null){
			throw new WishlistException("invalid wishlistitem");
		}
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        WishlistItemEntity wishlistObject=daoWishlist.addWishlistItem(wishlistItem);
        transaction.commit();
		return wishlistObject;
	}

}
