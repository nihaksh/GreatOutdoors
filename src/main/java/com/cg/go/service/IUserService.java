package com.cg.go.service;

import com.cg.go.entity.Userdata;

public interface IUserService {
	
	public Userdata addUser(Userdata user);

	public Userdata loginUser(Userdata u);
	public Userdata logout(Userdata user);
}
