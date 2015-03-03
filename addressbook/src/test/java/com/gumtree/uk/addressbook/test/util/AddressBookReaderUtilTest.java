package com.gumtree.uk.addressbook.test.util;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gumtree.uk.addressbook.entity.AddressBook;
import com.gumtree.uk.addressbook.util.GumtreeAddressBookReader;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:addressbook-context.xml")
public class AddressBookReaderUtilTest {

	@Autowired
	GumtreeAddressBookReader gumtreeAddressBookReader;
	
	@Test
	public void testAddressBookFileReader() {
		AddressBook addressBook = new AddressBook();
		gumtreeAddressBookReader.populateAddressDetails(addressBook);
		Assert.assertEquals(5, addressBook.getAddressList().size());
	}

}
