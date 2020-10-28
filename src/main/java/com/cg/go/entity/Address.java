package com.cg.go.entity;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Address {
	@Id
	private int addressId;
	private int buildingNo;
	private String streetName;
	private String area;
	private String city;
	private String state;
	private int zip;
	public Address(int aid,int bno,String sn,String area, String city,String state,int zip ) {
		this.addressId=aid;
		this.buildingNo=bno;
		this.streetName=sn;
		this.area=area;
		this.city=city;
		this.state=state;
		this.zip=zip;
	}
	public Address() {
		
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public int getBuildingNo() {
		return buildingNo;
	}
	public void setBuildingNo(int buildingNo) {
		this.buildingNo = buildingNo;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	@Override
	public int hashCode() {
		int hash=Objects.hashCode(addressId);
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
		Address other = (Address) obj;
		if (addressId != other.addressId)
			return false;
		return true;
	}
}