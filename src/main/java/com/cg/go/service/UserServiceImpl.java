
package com.cg.go.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.go.dao.IUserRepository;
import com.cg.go.dao.UserRepositoryImpl;
import com.cg.go.entity.Userdata;
import util.JpaUtil;

public class UserServiceImpl implements IUserService {
    private IUserRepository userDao;
    private EntityManager entityManager;

    public UserServiceImpl() {
        entityManager = JpaUtil.getInstance().getEntityManager();
        userDao = new UserRepositoryImpl(entityManager);
    }

    public UserServiceImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.userDao = new UserRepositoryImpl(entityManager);
    }

    @Override
    public Userdata addUser(Userdata user) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        user = userDao.addUser(user);
        transaction.commit();
        return user;
    }

    @Override
    public Userdata loginUser(Userdata user) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        user = userDao.loginUser(user);
        transaction.commit();
        return user;

    }

    @Override
    public Userdata logout(Userdata user) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        user = userDao.logout(user);
        transaction.commit();
        return user;

    }

}

		

	
