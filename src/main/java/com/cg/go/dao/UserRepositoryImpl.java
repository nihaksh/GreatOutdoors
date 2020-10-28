package com.cg.go.dao;

import javax.persistence.EntityManager;

import com.cg.go.entity.Userdata;

public class UserRepositoryImpl implements IUserRepository {
    private EntityManager entityManager;

    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Userdata addUser(Userdata user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public Userdata loginUser(Userdata userarg) {
        Userdata userdata = entityManager.find(Userdata.class, userarg.getUserId());
        if (userdata == null) {
            return null;
        }

        if (userdata.getUserPassword().equals(userarg.getUserPassword())) {
            System.out.println("logged in");
            return userdata;
        }

        return userarg;
    }
//	public Userdata loginUser(Userdata userarg) {
    //	userarg.setLoggedIn(true);
    //entityManager.merge(userarg);

    //	}

    @Override
    public Userdata logout(Userdata user) {
        return null;
        //ToDo
    }

}