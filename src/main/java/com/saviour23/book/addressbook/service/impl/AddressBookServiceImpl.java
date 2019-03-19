package com.saviour23.book.addressbook.service.impl;

import com.saviour23.book.addressbook.comparator.NameComparator;
import com.saviour23.book.addressbook.model.Contact;
import com.saviour23.book.addressbook.service.AddressBookService;
import com.saviour23.book.addressbook.service.PersistenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AddressBookServiceImpl implements AddressBookService {

    private Map<String, Set<Contact>> addressBooks;
    private PersistenceService persistenceService;

    @Autowired
    public AddressBookServiceImpl(PersistenceService persistenceService) {
        this.persistenceService = persistenceService;
        addressBooks = new ConcurrentHashMap();

    }


    @PostConstruct
    public void initializeAddressBook() {
        this.addressBooks.putAll(this.persistenceService.readAddressBook());
    }

    @PreDestroy
    public void savingAddressBookBeforeDestroy() {
        this.persistenceService.saveAddressBook(this.addressBooks);
    }

    @Override
    public void addContact(String addressBookName, Contact contact) {
        if (null == addressBooks.get(addressBookName)) {
            Set<Contact> contacts = new HashSet<>();
            contacts.add(contact);
            addressBooks.put(addressBookName, contacts);
        } else {
            addressBooks.get(addressBookName).add(contact);
        }
        //Method to save address book.
        persistenceService.saveAddressBook(addressBooks);

    }

    @Override
    public List<Contact> getAllSortedContacts(String addressBookName) {
        List<Contact> allSortedContacts = new ArrayList<>();
        if (null != addressBooks.get(addressBookName)) {
            allSortedContacts.addAll(addressBooks.get(addressBookName));
            Collections.sort(allSortedContacts, new NameComparator());
        }

        return Collections.unmodifiableList(allSortedContacts);
    }

    @Override
    public List<Contact> findAllUniqueContacts() {
        Set<String> addressBookNames = addressBooks.keySet();
        List<Contact> uniqueContacts = new ArrayList<>();
        for (String bookName : addressBookNames) {
            addressBooks.get(bookName).stream().forEach(contact -> {
                if (!uniqueContacts.contains(contact)) {
                    uniqueContacts.add(contact);
                }
            });
        }
        return uniqueContacts;
    }
}
