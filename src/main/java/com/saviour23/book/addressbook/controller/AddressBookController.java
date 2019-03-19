package com.saviour23.book.addressbook.controller;


import com.saviour23.book.addressbook.model.Contact;
import com.saviour23.book.addressbook.service.AddressBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for AddressBook.
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

    private static final Logger LOG = LoggerFactory.getLogger(AddressBookController.class);

    private final AddressBookService bookService;

    @Autowired
    public AddressBookController(AddressBookService bookService) {
        this.bookService = bookService;
    }


    /**
     * API exposed for fetchin all contacts related to specific Address Book.
     *
     * @param name addressbook name.
     * @return List of Contacts
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
    public List<Contact> getSpecificContact(@PathVariable String name) {
        return bookService.getAllSortedContacts(name);

    }

    /**
     * API exposed for adding contact for specific addressbook.
     *
     * @param name    address book name
     * @param contact contact to be added
     * @return Success Result for addition.
     */
    @PostMapping(value = "/{name}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addContact(@PathVariable String name, @RequestBody Contact contact) {

        bookService.addContact(name, contact);
        return "Contact name=" + contact.getName().getFullName() + ", added Successfully";
    }

    /**
     * API exposed for retrieving all unique contacts across all address books.
     *
     * @return list of unique contacts.
     */
    @GetMapping(value = "/all", produces = "application/json")
    public List<Contact> getAllContactByName() {
        return bookService.findAllUniqueContacts();
    }
}
