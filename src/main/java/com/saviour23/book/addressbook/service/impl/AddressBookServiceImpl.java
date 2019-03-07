package com.saviour23.book.addressbook.service.impl;

import com.saviour23.book.addressbook.model.AddressBook;
import com.saviour23.book.addressbook.model.AddressBookType;
import com.saviour23.book.addressbook.model.Contact;
import com.saviour23.book.addressbook.service.AddressBookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    private Map<AddressBookType, AddressBook> addressBooks;


    public AddressBookServiceImpl() {
        addressBooks = new ConcurrentHashMap();
    }


    @Override
    public void addContact(AddressBookType type, Contact contact) {
        if (null == addressBooks.get(type)) {
            AddressBook book = new AddressBook();
            book.addContact(contact);
            addressBooks.put(type, book);
        } else {
            addressBooks.get(type).addContact(contact);
        }

    }

    @Override
    public void removeContact(AddressBookType type, String id) {

        if (null != addressBooks.get(type)) {
            addressBooks.get(type).removeContact(id);
        }
    }

    @Override
    public Contact getContact(AddressBookType type, String id) {
        Contact contact = null;
        if (null != addressBooks.get(type)) {
            contact = addressBooks.get(type).getContactById(id);
        }
        return contact;
    }

    @Override
    public List<Contact> getAllContacts(AddressBookType type) {
        List<Contact> allContacts = new ArrayList<>();
        if (null != addressBooks.get(type)) {
            allContacts.addAll(addressBooks.get(type).getAllContacts()) ;
        }

        return allContacts;
    }
}
