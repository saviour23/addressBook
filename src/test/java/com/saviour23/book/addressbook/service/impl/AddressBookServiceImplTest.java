package com.saviour23.book.addressbook.service.impl;

import com.saviour23.book.addressbook.model.AddressBookType;
import com.saviour23.book.addressbook.model.Contact;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
public class AddressBookServiceImplTest {
    private static AddressBookServiceImpl addressBookService;

    @BeforeClass
    public static void init() {
        addressBookService = new AddressBookServiceImpl();
        Contact contact = new Contact();
        contact.setId("1");
        addressBookService.addContact(AddressBookType.CUSTOMER, contact);
    }


    @Test
    public void addContactTest() {
        Contact contact = new Contact();
        contact.setId("23");
        addressBookService.addContact(AddressBookType.CUSTOMER, contact);
        Contact receivedContact = addressBookService.getContact(AddressBookType.CUSTOMER, "23");
        Assert.assertEquals(contact, receivedContact);
    }


    @Test
    public void getAllContactTest() {
        List<Contact> addressList = addressBookService.getAllContacts(AddressBookType.CUSTOMER);
        Assert.assertNotNull(addressList);
        Contact contactReceived = addressList.stream().filter(contact -> contact.getId() == "1").findFirst().get();
        Assert.assertNotNull(contactReceived);

    }


    @Test
    public void deleteContactTest() {
        addressBookService.removeContact(AddressBookType.CUSTOMER, "1");
        List<Contact> addressList = addressBookService.getAllContacts(AddressBookType.CUSTOMER);
        boolean isPresent=  addressList.stream().filter(contact -> contact.getId() == "1").findFirst().isPresent();
        Assert.assertFalse(isPresent);
    }
}
