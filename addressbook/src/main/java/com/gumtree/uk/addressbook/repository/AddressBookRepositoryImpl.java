package com.gumtree.uk.addressbook.repository;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gumtree.uk.addressbook.dao.AddressBookDao;
import com.gumtree.uk.addressbook.entity.Address;
import com.gumtree.uk.addressbook.entity.AddressBook;
import com.gumtree.uk.addressbook.util.DateUtil;

public class AddressBookRepositoryImpl implements AddressBookRepository {

	@Autowired
	AddressBookDao addressBookDao;
	
	private AddressBook addressBook;
	
	public AddressBook getAddressBook() {
		if(addressBook == null)
			addressBook = addressBookDao.getAddressList();
		return addressBook;
	}

	public Address getAddressByName(String name) {
		return addressBookDao.getAddressByName(name);
	}

	public int getGenderCount(String genderType){
		int genderCount = 0;
		List<Address> addressList = getAddressBook().getAddressList();
		for(Address address : addressList){
			if(genderType.equalsIgnoreCase(address.getGender().trim())){
				genderCount++;
			}
		}
		return genderCount;
	}

	public Address getOlderPerson(){
		
		Collections.sort(getAddressBook().getAddressList());
		
		return getAddressBook().getAddressList().get(0);
	}
	
	public String getHowOldBetweenPersons(String name1, String name2){
		
		Address address1 = addressBookDao.getAddressByName(name1);
		Address address2 = addressBookDao.getAddressByName(name2);
		
		return DateUtil.get_duration(address1.getDateOfBirth(), address2.getDateOfBirth());
	}
	
	public void setAddressBook(AddressBook addressBook) {
		this.addressBook = addressBook;
	}
	
}
