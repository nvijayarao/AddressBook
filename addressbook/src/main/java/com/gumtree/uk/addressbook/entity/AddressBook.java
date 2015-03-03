package com.gumtree.uk.addressbook.entity;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	private List<Address> addressList;
	
	public List<Address> getAddressList() {
		if(addressList == null)
			addressList = new ArrayList<Address>();
		
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}
}
