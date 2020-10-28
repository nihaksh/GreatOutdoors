package com.cg.go.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.cg.go.exception.InvalidProductIdException;
import com.cg.go.exception.WishlistException;
import com.cg.go.exception.WishlistNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.go.entity.Userdata;
import com.cg.go.entity.WishlistItemEntity;
import com.cg.go.service.WishlistServiceImpl;

import org.junit.jupiter.api.function.Executable;
import util.ProjectConstants;

public class WishListServiceImplTest {
    EntityManager entityManager;

    WishlistServiceImpl wishService;

    @BeforeEach
    public void setup() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(ProjectConstants.PERSISTENEUNIT_NAME);
        entityManager = emf.createEntityManager();
        wishService = new WishlistServiceImpl(entityManager);

    }

    /**
     * scenario :wishlist added
     */
    @Test
    void testAddWishlist_1() throws WishlistException {
        List<String> products = new ArrayList<>();
        products.add("p1");
        WishlistItemEntity entity = new WishlistItemEntity(21, products);
        entity = wishService.addWishlistItem(entity);
        TypedQuery<WishlistItemEntity> query = entityManager.createQuery("from WishlistItemEntity", WishlistItemEntity.class);
        List<WishlistItemEntity> wishlists = query.getResultList();
        Assertions.assertEquals(1, wishlists.size());
        WishlistItemEntity storedWishlist = wishlists.get(0);
        Assertions.assertEquals(entity.getWishlistId(), storedWishlist.getWishlistId());
        Assertions.assertTrue(entity.getProductId().contains("p1"));
    }

    /**
     * scenario : WishlistException is thrown when null is passed as argument
     */
    @Test
    void testAddWishlist_2() throws WishlistException {
        WishlistItemEntity entity = null;
        Executable executable = () -> wishService.addWishlistItem(entity);
        Assertions.assertThrows(WishlistException.class, executable);
    }

    /**
     * scenario: product is added
     */
    @Test
    public void testAddProduct_1() {
        List<String> products = new ArrayList<>();
        WishlistItemEntity entity = new WishlistItemEntity(21, products);
        entityManager.persist(entity);
        wishService.addProductToWishlist("p1", entity.getWishlistId());
        WishlistItemEntity stored = entityManager.find(WishlistItemEntity.class, entity.getWishlistId());
        Assertions.assertTrue(stored.getProductId().contains("p1"));
    }

    /**
     * scenario: InvalidProductIdException
     */
    @Test
    public void testAddProduct_2() {
        List<String> products = new ArrayList<>();
        WishlistItemEntity entity = new WishlistItemEntity(21, products);
        entityManager.persist(entity);
        Executable executable = () -> wishService.addProductToWishlist("", entity.getWishlistId());
        Assertions.assertThrows(InvalidProductIdException.class, executable);
    }

    /**
     * scenario: WishlistNotFoundException is thrown
     */
    @Test
    public void testAddProduct_3() {
         Executable executable = () -> wishService.addProductToWishlist("p1", 16532);
        Assertions.assertThrows(WishlistNotFoundException.class, executable);
    }

}
