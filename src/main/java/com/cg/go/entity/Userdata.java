package com.cg.go.entity;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
@Entity
@NamedQuery(name = "Loggin in", query = "select c from Userdata c where c.userName = :username and c.userPassword=:password")
public class Userdata {
	
	private String userName;
	@Id
	@GeneratedValue
	private int userId;
	private String userType;
/*	private boolean loggedIn;
	public boolean isLoggedIn() {select c from UserData c
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;}
	*/
	private String userPassword;
	public Userdata(String userName, String userType, String userPassword) {
		this.userName = userName;
		//this.userId = userId;
		this.userType = userType;
		this.userPassword = userPassword;
	}
	public Userdata() {
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public int hashCode() {
		int hash=Objects.hashCode(userId);
		return hash;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Userdata other = (Userdata) obj;
		if (userId != other.userId)
			return false;
		return true;
	}
	
}
	