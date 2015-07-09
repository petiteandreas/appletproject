package com.andriidnikitin.appletapp.ui.model;

import java.util.Date;

public class PassportDetailsModel {
	
	private String passportSerial;

	private String passportId;
	
	private Date dateOfRegistrating;
	
	private String registrator;
	
	private String registratorDepartment;
	
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

	public void setDateOfRegistrating(Date dateOfRegistrating) {
		this.dateOfRegistrating = dateOfRegistrating;
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

}
