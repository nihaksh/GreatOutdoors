
package com.test;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.go.dao.UserRepositoryImpl;
import com.cg.go.entity.Userdata;
import com.cg.go.service.IUserService;
import com.cg.go.service.UserServiceImpl;

import util.JpaUtil;

public class TestUserdata {

EntityManager entityManager;
UserServiceImpl impl=new UserServiceImpl();
 @BeforeEach
 public void setup() {
  //   impl = new UserRepositoryImpl();

     JpaUtil jpaUtil = JpaUtil.getInstance();
     entityManager = jpaUtil.getEntityManager();
 }

 @AfterEach
 public void clear() {
     EntityTransaction transaction = entityManager.getTransaction();
     transaction.begin();
     Query query = entityManager.createQuery("delete from Address");
     query.executeUpdate();
     transaction.commit();
 }
 @Test
 void testUserdata(){
	Userdata userdata=new Userdata();
	userdata.setUserName("Niha");
	userdata.setUserType("Admin");
	userdata.setUserPassword("n1999");
	impl.addUser(userdata);
	TypedQuery<Userdata> query = entityManager.createQuery("from Userdata", Userdata.class);
    List<Userdata> list = query.getResultList();
    Assertions.assertEquals(1, list.size());
}
}

