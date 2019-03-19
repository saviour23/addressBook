package com.saviour23.book.addressbook.service;

import com.saviour23.book.addressbook.model.Contact;

import java.util.List;

/**
 * Interface for Address Book Service.
 */
public interface AddressBookService {

    /**
     * Method for adding contact into specific address book.
     * @param addressBookName name of addressBook
     * @param contact Contact to be added.
     */
    void addContact(String addressBookName, Contact contact);

    /**
     * Method to retrieve all contact, sorted by name, for specific addressbook.
     * @param addressBookName addressbook name
     * @return sorted list contacts.
     */
    List<Contact> getAllSortedContacts(String addressBookName);

    List<Contact> findAllUniqueContacts();
}
