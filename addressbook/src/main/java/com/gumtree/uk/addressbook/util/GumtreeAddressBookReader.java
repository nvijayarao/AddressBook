package com.gumtree.uk.addressbook.util;

import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.gumtree.uk.addressbook.entity.Address;
import com.gumtree.uk.addressbook.entity.AddressBook;

public class GumtreeAddressBookReader extends AbstractPropertyReader{

	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	
	public String getFileName() {
		return properties.getProperty("DATAFILE").trim();
	}

	public AddressBook populateAddressDetails(AddressBook addressBook) {  
		try {
			Scanner scanner = new Scanner(this.getClass().getClassLoader().getResourceAsStream(getFileName()));
			while (scanner.hasNextLine()) {
				StringTokenizer stringtokenizer = new StringTokenizer(scanner.nextLine(), ",");
				Address address = new Address();
				while (stringtokenizer.hasMoreElements()) {
					address.setName(stringtokenizer.nextToken());
					address.setGender(stringtokenizer.nextToken());
					address.setDateOfBirth(formatter.parse(stringtokenizer.nextToken()));
				}
				addressBook.getAddressList().add(address);
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addressBook;
	}

}
