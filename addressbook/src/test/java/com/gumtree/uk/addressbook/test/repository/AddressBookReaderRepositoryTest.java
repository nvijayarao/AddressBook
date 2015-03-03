package com.gumtree.uk.addressbook.test.repository;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gumtree.uk.addressbook.entity.Address;
import com.gumtree.uk.addressbook.repository.AddressBookRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:addressbook-context.xml")
public class AddressBookReaderRepositoryTest {

	@Autowired
	AddressBookRepository addressBookRepository;
	
	@Test
	public void testGetOlderPerson() {
		Address address = addressBookRepository.getOlderPerson();
		Assert.assertEquals("Wes Jackson", address.getName());
	}

	@Test
	public void testGetOldestBetweenPersons() {
		Assert.assertEquals("2862 Days 00h 00m 00s", addressBookRepository.getHowOldBetweenPersons("Bill McKnight", "Paul Robinson"));	
	}
	
	@Test
	public void testGetGenderCount() {
		Assert.assertEquals(3, addressBookRepository.getGenderCount("Male"));	
	}
}
