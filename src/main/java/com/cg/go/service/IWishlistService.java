package com.cg.go.service;

import java.util.List;
import com.cg.go.entity.WishlistItemEntity;
import com.cg.go.exception.WishlistException;

public interface IWishlistService {

	List<WishlistItemEntity> findAllItems();

	List<WishlistItemEntity> findWishlist(String userId);

	WishlistItemEntity findWishlistItem(String productId, String userId);
	void addProductToWishlist(String prodId,long wishlistID);
	void deleteWishlistItem(String productId, String userId) throws WishlistException;

	void deleteWishlist(String userId) throws WishlistException;

	WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem) throws WishlistException;

}
