package com.gumtree.uk.addressbook.entity;

import java.util.Date;


public class Address implements Comparable<Address> {

	private int id;
	private String name;
	private String gender;
	private Date dateOfBirth;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public int compareTo(Address add) {
		if (getDateOfBirth() == null || add.getDateOfBirth() == null)
			return 0;
		return getDateOfBirth().compareTo(add.getDateOfBirth());
	}
}
