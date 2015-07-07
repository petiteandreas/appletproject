package com.andriidnikitin.appletapp.bl;

import java.util.Date;

public class Document {	

	private String surname;
	
	private String name;
	
	private String patronym;
	
	private Date birthday;
	
	private String birthplaceCity;
	
	private String birthplaceArea;
	
	private String birthplaceRegion;
	
	private String passportSerial;
	
	private String passportId;
	
	private Date dateOfRegistrating;
	
	private String registrator;
	
	private String registratorDepartment;


	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPatronym() {
		return patronym;
	}
	
	public void setPatronym(String patronym) {
		this.patronym = patronym;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public String getPassportSerial() {
		return passportSerial;
	}
	
	public void setPassportSerial(String passportSerial) {
		this.passportSerial = passportSerial;
	}
	
	public String getPassportId() {
		return passportId;
	}
	
	public void setPassportId(String passportId) {
		this.passportId = passportId;
	}
	
	public Date getDateOfRegistrating() {
		return dateOfRegistrating;
	}
	
	public void setDateOfRegistrating(Date date) {
		this.dateOfRegistrating = date;
	}
	
	public String getRegistrator() {
		return registrator;
	}
	
	public void setRegistrator(String registrator) {
		this.registrator = registrator;
	}
	
	public String getRegistratorDepartment() {
		return registratorDepartment;
	}
	
	public void setRegistratorDepartment(String registratorDepartment) {
		this.registratorDepartment = registratorDepartment;
	}
	
	public String getBirthplaceCity() {
		return birthplaceCity;
	}
	
	public void setBirthplaceCity(String birthplaceCity) {
		this.birthplaceCity = birthplaceCity;
	}
	
	public String getBirthplaceArea() {
		return birthplaceArea;
	}
	
	public void setBirthplaceArea(String birthplaceArea) {
		this.birthplaceArea = birthplaceArea;
	}
	
	public String getBirthplaceRegion() {
		return birthplaceRegion;
	}
	
	public void setBirthplaceRegion(String birthplaceRegion) {
		this.birthplaceRegion = birthplaceRegion;
	}	
	
	public String getSNP(){
		return getSurname() + " " + getName()  +
		" " + getPatronym();
	}
}
