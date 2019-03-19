package com.saviour23.book.addressbook.service;

import com.saviour23.book.addressbook.model.Contact;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Service responsible for saving the addressbook.
 */
public interface PersistenceService {
    /**
     * Method for saving All Address Books.
     *
     * @param addressBooks
     */
    void saveAddressBook(Map<String, Set<Contact>> addressBooks);

    /**
     * Method for retriving All Address Book saved.
     *
     * @return Map<String ,List<Contact>>
     */
    Map<String, Set<Contact>> readAddressBook();


}
