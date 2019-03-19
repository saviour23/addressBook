package com.saviour23.book.addressbook.service.impl;

import com.saviour23.book.addressbook.exception.ValidationException;
import com.saviour23.book.addressbook.model.Contact;
import com.saviour23.book.addressbook.model.Name;
import com.saviour23.book.addressbook.model.PhoneNumber;
import com.saviour23.book.addressbook.model.PhoneNumberType;
import com.saviour23.book.addressbook.service.PersistenceService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;

@RunWith(SpringRunner.class)
public class AddressBookServiceImplTest {
    private static AddressBookServiceImpl addressBookService;

    @MockBean
    private PersistenceService persistenceService;

    @Before
    public void init() {
        addressBookService = new AddressBookServiceImpl(persistenceService);
    }


    @Test
    public void addContactTest() {
        Contact c = new Contact();
        Name name = new Name("Neeraj", "Negi");
        PhoneNumber number = new PhoneNumber("0123456789", PhoneNumberType.MOBILE);
        PhoneNumber number1 = new PhoneNumber("3456723456", PhoneNumberType.HOME);
        c.setName(name);
        c.addPhoneNumber(number);
        c.addPhoneNumber(number1);
        addressBookService.addContact("Book1", c);
        List<Contact> contacts = addressBookService.getAllSortedContacts("Book1");
        Assert.assertTrue(contacts.contains(c));

    }

    @Test(expected = ValidationException.class)
    public void addContactTest_Negative_EmptyfirstName() {
        Contact c = new Contact();
        Name name = new Name("", "Negi");
        PhoneNumber number = new PhoneNumber("0123456789", PhoneNumberType.MOBILE);
        PhoneNumber number1 = new PhoneNumber("3456723456", PhoneNumberType.HOME);
        c.setName(name);
        c.addPhoneNumber(number);
        c.addPhoneNumber(number1);
        addressBookService.addContact("Book1", c);
    }

    @Test(expected = ValidationException.class)
    public void addContactTest_Negative_EmptyLastName() {
        Contact c = new Contact();
        Name name = new Name("Neeraj", "");
        PhoneNumber number = new PhoneNumber("0123456789", PhoneNumberType.MOBILE);
        PhoneNumber number1 = new PhoneNumber("3456723456", PhoneNumberType.HOME);
        c.setName(name);
        c.addPhoneNumber(number);
        c.addPhoneNumber(number1);
        addressBookService.addContact("Book1", c);
    }

    @Test(expected = ValidationException.class)
    public void addContactTest_Negative_EmptyName() {
        Contact c = new Contact();
        Name name = new Name(null, null);
        PhoneNumber number = new PhoneNumber("0123456789", PhoneNumberType.MOBILE);
        PhoneNumber number1 = new PhoneNumber("3456723456", PhoneNumberType.HOME);
        c.setName(name);
        c.addPhoneNumber(number);
        c.addPhoneNumber(number1);
        addressBookService.addContact("Book1", c);
    }

    @Test
    public void getAllSortedContactsTest() {
        Contact c = new Contact();
        Name name = new Name("Neeraj", "Negi");
        PhoneNumber number = new PhoneNumber("0123456789", PhoneNumberType.MOBILE);
        PhoneNumber number1 = new PhoneNumber("3456723456", PhoneNumberType.HOME);
        c.setName(name);
        c.addPhoneNumber(number);
        c.addPhoneNumber(number1);
        addressBookService.addContact("Book1", c);
        List<Contact> contacts = addressBookService.getAllSortedContacts("Book1");
        Assert.assertTrue(contacts.contains(c));
    }

    @Test
    public void getAllSortedContactsTest_Negative_UnknownBook() {
        List<Contact> contacts = addressBookService.getAllSortedContacts("Book2");
        Assert.assertTrue(CollectionUtils.isEmpty(contacts));
    }

    @Test
    public void findAllUniqueContactsTest() {
        Contact c = new Contact();
        Name name = new Name("Neeraj", "Negi");
        PhoneNumber number = new PhoneNumber("0123456789", PhoneNumberType.MOBILE);
        PhoneNumber number1 = new PhoneNumber("3456723456", PhoneNumberType.HOME);
        c.setName(name);
        c.addPhoneNumber(number);
        c.addPhoneNumber(number1);
        addressBookService.addContact("Book1", c);

        Contact c1 = new Contact();
        Name name1 = new Name("Neeraj", "Negi");
        PhoneNumber number2 = new PhoneNumber("0123456789", PhoneNumberType.MOBILE);
        PhoneNumber number3 = new PhoneNumber("3456723456", PhoneNumberType.HOME);
        c1.setName(name1);
        c1.addPhoneNumber(number2);
        c1.addPhoneNumber(number3);
        addressBookService.addContact("Book3", c1);

        List<Contact> allUniqueContacts = addressBookService.findAllUniqueContacts();
        Assert.assertEquals(1, allUniqueContacts.size());
    }

}
