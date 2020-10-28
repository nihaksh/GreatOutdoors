
package com.cg.go.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import com.cg.go.entity.WishlistItemEntity;

import com.cg.go.exception.WishlistException;
import com.cg.go.exception.WishlistNotFoundException;

public class WishlistRepositoryImpl implements IWishlistRepository {
    private EntityManager entityManager;

    public WishlistRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<WishlistItemEntity> findAllItems() {
        List<WishlistItemEntity> query = entityManager.createQuery("select c from WishlistItemEntity c", WishlistItemEntity.class).getResultList();
        //List<WishlistItemEntity> list=query.getResultList();
        return query;
    }

    public List<WishlistItemEntity> findWishlist(String userId) {
        int userIdInt = Integer.parseInt(userId);
        TypedQuery<WishlistItemEntity> query = entityManager.createQuery("from WishlistItemEntity where userId=:userId", WishlistItemEntity.class);
        query.setParameter("userId", userIdInt);
        List<WishlistItemEntity> list = query.getResultList();
        if(list.isEmpty()){
            throw new WishlistNotFoundException("wishlist not found for user="+userId);
        }
        return list;
    }

    public WishlistItemEntity findWishlistItem(String productId, String userId) {
        List<WishlistItemEntity> list = findWishlist(userId);
         for (WishlistItemEntity entity:list){
         List<String>products=  entity.getProductId();
         if(products!=null && products.contains(productId)){
             return entity;
         }
        }

        throw new WishlistNotFoundException("wishlist not found for user="+userId+" product="+productId);

    }

    public WishlistItemEntity findWishListById(long wishlistId){
        String ql = "from WishlistItemEntity  where wishlistId =:wishId ";
        TypedQuery<WishlistItemEntity> query = entityManager.createQuery(ql, WishlistItemEntity.class);
        query.setParameter("wishId", wishlistId);
        List<WishlistItemEntity> list = query.getResultList();
        if (list.isEmpty()) {
            throw new WishlistNotFoundException("wishlist not found for wishlistid="+wishlistId);
        }
        WishlistItemEntity entity = list.get(0);
        return entity;
    }

    public void addProductToWishlist(String prodId, long wishlistID) {
        WishlistItemEntity entity = findWishListById(wishlistID);
        List<String> productIds = entity.getProductId();
        if (productIds == null) {
            productIds = new ArrayList<>();
            entity.setProductId(productIds);
        }
        if (!productIds.contains(prodId)) {
            productIds.add(prodId);
            entityManager.merge(entity);
        }

    }

    public void deleteWishlistItem(String productId, String userId) throws WishlistException {
        WishlistItemEntity entity = findWishlistItem(productId, userId);

        List<String> productIds = entity.getProductId();
        if (productIds == null || !productIds.contains(productId)) {
            return;
        }
        productIds.remove(productId);
        entityManager.merge(entity);
    }

    public void deleteWishlist(String userId) throws WishlistException {
        WishlistItemEntity wishlistItemEntity = entityManager.find(WishlistItemEntity.class, userId);
        if (wishlistItemEntity == null) {
            throw new WishlistException("WishlistItemEntity not found");
        }

        entityManager.remove(wishlistItemEntity);

    }

    public WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem) throws WishlistException {
        entityManager.persist(wishlistItem);
        return wishlistItem;

    }

}
