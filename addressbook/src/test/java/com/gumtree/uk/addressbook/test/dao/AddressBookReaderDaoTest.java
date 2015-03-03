package com.gumtree.uk.addressbook.test.dao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gumtree.uk.addressbook.dao.AddressBookDao;
import com.gumtree.uk.addressbook.entity.Address;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:addressbook-context.xml")
public class AddressBookReaderDaoTest{

	@Autowired
	AddressBookDao addressBookDao;
	
	@Test
	public void testGetAddressList(){
		Assert.assertNotNull(addressBookDao.getAddressList());
		Assert.assertEquals(5, addressBookDao.getAddressList().getAddressList().size());
	}
	
	@Test
	public void testGetAddressByName(){
		Address address1 = addressBookDao.getAddressByName("Bill McKnight");
		Assert.assertEquals("Bill McKnight", address1.getName());
		Address address2 = addressBookDao.getAddressByName("Paul Robinson");
		Assert.assertEquals("Paul Robinson", address2.getName());
	}
}
