
package com.cg.go.dao;

import java.io.Serializable;
import com.cg.go.entity.Userdata;

public interface IUserRepository {
	public Userdata addUser(Userdata user);
	public Userdata loginUser(Userdata u);
	public Userdata logout(Userdata user);
}
