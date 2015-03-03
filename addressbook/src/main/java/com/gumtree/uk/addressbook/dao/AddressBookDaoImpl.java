package com.gumtree.uk.addressbook.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.gumtree.uk.addressbook.entity.Address;
import com.gumtree.uk.addressbook.entity.AddressBook;
import com.gumtree.uk.addressbook.util.GumtreeAddressBookReader;

public class AddressBookDaoImpl implements AddressBookDao {

	@Autowired
	GumtreeAddressBookReader gumtreeAddressBookReader;
	
	public AddressBook getAddressList() {
		AddressBook addressBook = new AddressBook(); 
		gumtreeAddressBookReader.populateAddressDetails(addressBook);
		
		return addressBook;
	}

	public Address getAddressByName(String name) {
		AddressBook addressBook = getAddressList();
		for(Address address : addressBook.getAddressList()){
			if(name.equalsIgnoreCase(address.getName())){
				return address;
			}
		}
		return null;
	}

}
