package com.gumtree.uk.addressbook.repository;

import com.gumtree.uk.addressbook.entity.Address;
import com.gumtree.uk.addressbook.entity.AddressBook;

public interface AddressBookRepository {

	AddressBook getAddressBook();
	Address getAddressByName(String name);
	int getGenderCount(String genderType);
	Address getOlderPerson();
	String getHowOldBetweenPersons(String name1, String name2);
}
