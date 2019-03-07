package com.saviour23.book.addressbook.service;

import com.saviour23.book.addressbook.model.AddressBookType;
import com.saviour23.book.addressbook.model.Contact;

import java.util.List;

/**
 * Interface for Address Book Service.
 */
public interface AddressBookService {


    void addContact(AddressBookType type, Contact contact);

    void removeContact(AddressBookType type,String id);

    Contact getContact(AddressBookType type,String id);

    List<Contact> getAllContacts(AddressBookType type);

    List<Contact> findAllContactsByName(String name);
}
