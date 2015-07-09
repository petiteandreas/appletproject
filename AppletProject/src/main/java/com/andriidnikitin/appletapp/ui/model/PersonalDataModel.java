package com.andriidnikitin.appletapp.ui.model;

import java.util.Date;

public class PersonalDataModel {
	
	private String surname;

	private String name;
	
	private String patronym;
	
	private Date birthday;
	
	private String birthplaceCity;

	private String birthplaceArea;
	
	private String birthplaceRegion;
	
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

}
