package com.cg.go.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.go.entity.ProductEntity;
import com.cg.go.entity.Userdata;
import com.cg.go.entity.WishlistItemEntity;
import com.cg.go.exception.WishlistException;
import com.cg.go.service.*;

public class Test {
    IProductService productService=new ProductServiceImpl();
    IUserService userService = new UserServiceImpl();
    IWishlistService wishlistService = new WishlistServiceImpl();

    public static void main(String[] args) throws WishlistException {
       Test test=new Test();
       test.execute();
    }

    public void execute() throws WishlistException{
        Userdata userdata = new Userdata("Niha", "Admin", "n1999");
       userdata= userService.addUser(userdata);
        System.out.println("Added Sucessfully");

        List<String> wishlist = new ArrayList<String>();
        //	wishlist.add("pune");
        //wishlist.add("hyd");
        WishlistItemEntity item = new WishlistItemEntity(userdata.getUserId(), wishlist);
        wishlistService.addWishlistItem(item);

        WishlistItemEntity item2 = new WishlistItemEntity(userdata.getUserId(), wishlist);
        wishlistService.addWishlistItem(item2);

        WishlistItemEntity item3 = new WishlistItemEntity(userdata.getUserId(), wishlist);
        ProductEntity productEntity=new ProductEntity();
        productEntity.setProductId("p1");

        wishlistService.addProductToWishlist("p1", item.getWishlistId());
        System.out.println("wishlist2added");

        List<WishlistItemEntity> li = wishlistService.findAllItems();
        for (WishlistItemEntity entity : li) {
            System.out.println("wishlist="+entity.getWishlistId()+" products="+entity.getProductId());
        }

        wishlistService.deleteWishlistItem("p1", ""+userdata.getUserId());

    }
}

