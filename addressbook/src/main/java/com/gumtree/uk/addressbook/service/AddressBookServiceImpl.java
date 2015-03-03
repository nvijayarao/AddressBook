package com.gumtree.uk.addressbook.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gumtree.uk.addressbook.entity.Address;
import com.gumtree.uk.addressbook.entity.AddressBook;
import com.gumtree.uk.addressbook.repository.AddressBookRepository;

public class AddressBookServiceImpl implements AddressBookService {

	@Autowired
	AddressBookRepository addressBookRepository;
	
	public AddressBook getAddressBook() {
		return addressBookRepository.getAddressBook();
	}

	public Address getAddressByName(String name) {
		return addressBookRepository.getAddressByName(name);
	}

	public int getGenderCount(String genderType){
		return addressBookRepository.getGenderCount(genderType);
	}

	public Address getOlderPerson(){
		return addressBookRepository.getOlderPerson();
	}
	
	public String getHowOldBetweenPersons(String name1, String name2){
		return addressBookRepository.getHowOldBetweenPersons(name1, name2);
	}
}
