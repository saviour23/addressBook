package com.saviour23.book.addressbook.service.impl;


import com.saviour23.book.addressbook.model.Contact;
import com.saviour23.book.addressbook.model.Name;
import com.saviour23.book.addressbook.model.PhoneNumber;
import com.saviour23.book.addressbook.model.PhoneNumberType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@RunWith(SpringRunner.class)
public class PersistenceServiceImplTest {

    PersistenceServiceImpl persistenceService;

    @Before
    public void init() {
        persistenceService = new PersistenceServiceImpl();
    }

    @Test
    public void saveAddressBookTest() {
        Map<String, Set<Contact>> addressBooks = createAddressBook();
        Map<String, Set<Contact>> anotherAddressBooks;
        persistenceService.saveAddressBook(addressBooks);
        anotherAddressBooks = persistenceService.readAddressBook();
        Assert.assertEquals(anotherAddressBooks.keySet().size(), addressBooks.keySet().size());

    }
    @Test
    public void saveAddressBookTest_Negative_NullValu(){
        persistenceService.saveAddressBook(null);
        Map<String, Set<Contact>> addressBooks = createAddressBook();
        Map<String, Set<Contact>> anotherAddressBooks;
        persistenceService.saveAddressBook(addressBooks);
        anotherAddressBooks = persistenceService.readAddressBook();
        Assert.assertEquals(1, addressBooks.keySet().size());

    }

    private Map<String, Set<Contact>> createAddressBook(){
        Map<String, Set<Contact>> addressBooks = new ConcurrentHashMap<>();
        Contact c = new Contact();
        Name name = new Name("Test", "Test");
        PhoneNumber number = new PhoneNumber("0123456789", PhoneNumberType.MOBILE);
        PhoneNumber number1 = new PhoneNumber("3456723456", PhoneNumberType.HOME);
        c.setName(name);
        c.addPhoneNumber(number);
        c.addPhoneNumber(number1);

        Set<Contact> contacts = new HashSet<>();
        contacts.add(c);
        addressBooks.put("TestBook", contacts);
        return addressBooks;
    }
}
