package com.gumtree.uk.addressbook.service;

import com.gumtree.uk.addressbook.entity.Address;
import com.gumtree.uk.addressbook.entity.AddressBook;

public interface AddressBookService {

	AddressBook getAddressBook();
	Address getAddressByName(String name);
	int getGenderCount(String genderType);
	Address getOlderPerson();
	String getHowOldBetweenPersons(String name1, String name2);
}
