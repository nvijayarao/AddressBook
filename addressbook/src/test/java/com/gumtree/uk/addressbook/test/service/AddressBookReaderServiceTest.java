package com.gumtree.uk.addressbook.test.service;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gumtree.uk.addressbook.entity.Address;
import com.gumtree.uk.addressbook.service.AddressBookService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:addressbook-context.xml")
public class AddressBookReaderServiceTest {

	@Autowired
	AddressBookService addressBookService;
	
	@Test
	public void testGetAddressList(){
		Assert.assertNotNull(addressBookService.getAddressBook());
		Assert.assertEquals(5, addressBookService.getAddressBook().getAddressList().size());
	}
	
	@Test
	public void testGetAddressByName(){
		Address address1 = addressBookService.getAddressByName("Bill McKnight");
		Assert.assertEquals("Bill McKnight", address1.getName());
		Address address2 = addressBookService.getAddressByName("Paul Robinson");
		Assert.assertEquals("Paul Robinson", address2.getName());
	}
	
	@Test
	public void testGetOlderPerson() {
		Address address = addressBookService.getOlderPerson();
		Assert.assertEquals("Wes Jackson", address.getName());
	}

	@Test
	public void testGetOldestBetweenPersons() {
		Assert.assertEquals("2862 Days 00h 00m 00s", addressBookService.getHowOldBetweenPersons("Bill McKnight", "Paul Robinson"));	
	}
	
	@Test
	public void testGetGenderCount() {
		Assert.assertEquals(3, addressBookService.getGenderCount("Male"));	
	}
}
