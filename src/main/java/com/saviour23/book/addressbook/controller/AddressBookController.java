package com.saviour23.book.addressbook.controller;


import com.saviour23.book.addressbook.model.AddressBookType;
import com.saviour23.book.addressbook.model.Contact;
import com.saviour23.book.addressbook.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for AddressBook.
 * <p>
 * Assumption- AddressBookType Customer is supported but it can be extended for multiple types.
 */
@RestController
@RequestMapping("/addressbook/contacts")
public class AddressBookController {


    private final AddressBookService bookService;

    @Autowired
    public AddressBookController(AddressBookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Contact getSpecificContact(@PathVariable String id) {
        return bookService.getContact(AddressBookType.CUSTOMER, id);
    }

    @GetMapping(value = "", produces = "application/json")
    public List<Contact> getAllContacts() {
        return bookService.getAllContacts(AddressBookType.CUSTOMER);
    }


    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteContact(@PathVariable String id) {

        bookService.removeContact(AddressBookType.CUSTOMER, id);
        return "Contact id=" + id + ", removed successfully.";
    }


    @PostMapping(value = "/addcontact", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addContact(@RequestBody Contact contact) {

        bookService.addContact(AddressBookType.CUSTOMER, contact);
        return "Contact name=" + contact.getName() + ", added Successfully";
    }
}
