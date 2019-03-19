package com.saviour23.book.addressbook.service.impl;

import com.saviour23.book.addressbook.model.Contact;
import com.saviour23.book.addressbook.service.PersistenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * PersistenceService implementation.
 */
@Service
public class PersistenceServiceImpl implements PersistenceService {
    private static String ADDRESS_BOOK_FILE = "AddressBook.ser";

    private static final Logger LOG = LoggerFactory.getLogger(PersistenceServiceImpl.class);

    /**
     * Save adressbook. for this project it will serialize full address book.
     *
     * @param addressBooks
     */
    @Override
    public void saveAddressBook(Map<String, Set<Contact>> addressBooks) {
        try (
                OutputStream file = new FileOutputStream(ADDRESS_BOOK_FILE);
                OutputStream buffer = new BufferedOutputStream(file);
                ObjectOutput output = new ObjectOutputStream(buffer);
        ) {
            if (!CollectionUtils.isEmpty(addressBooks)) {

                output.writeObject(addressBooks);
            }
        } catch (IOException ex) {
            LOG.error("Error in saving Address Book, message= {}, exception= {}", ex.getMessage(), ex);
        }
    }

    @Override
    public Map<String, Set<Contact>> readAddressBook() {
        Map<String, Set<Contact>> addressBooks = new ConcurrentHashMap<>();
        try (
                InputStream file = new FileInputStream(ADDRESS_BOOK_FILE);
                InputStream buffer = new BufferedInputStream(file);
                ObjectInput input = new ObjectInputStream(buffer);
        ) {
            LOG.info("Retriving AddressBook");
            Map<String, Set<Contact>> addressBook = (Map<String, Set<Contact>>) input.readObject();
            addressBooks.putAll(addressBook);

        } catch (Exception ex) {
            LOG.error("Error in retriving Address Book, message= {}, exception= {}", ex.getMessage(), ex);
        }

        return addressBooks;
    }
}
