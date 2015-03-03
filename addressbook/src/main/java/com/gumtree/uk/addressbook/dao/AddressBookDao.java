package com.gumtree.uk.addressbook.dao;

import com.gumtree.uk.addressbook.entity.Address;
import com.gumtree.uk.addressbook.entity.AddressBook;

public interface AddressBookDao {

	AddressBook getAddressList();
	Address getAddressByName(String name);
	
}
