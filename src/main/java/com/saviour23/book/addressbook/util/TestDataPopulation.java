package com.saviour23.book.addressbook.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saviour23.book.addressbook.model.Contact;
import com.saviour23.book.addressbook.service.AddressBookService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * This is temporary component to pupulate the customerData.
 */
@Component
public class TestDataPopulation {


    @Autowired
    AddressBookService bookService;

    private static final String FRIENDS_ADDRESS_BOOK = "testdata/Friends.json";
    private static final String OFFICE_ADDRESS_BOOK = "testdata/Office.json";
    private static final String FRIENDS_ADDRESSBOOK_NAME = "Friends";
    private static final String OFFICE_ADDRESSBOOK_NAME = "Office";

    @PostConstruct
    private void polulateDataForTwoContacts() throws IOException {
        generateData();

    }


    private void generateData() throws IOException {
        List<Contact> friendsContact = readContactJson(FRIENDS_ADDRESS_BOOK);

        friendsContact.stream().forEach(contact -> bookService.addContact(FRIENDS_ADDRESSBOOK_NAME, contact));

        List<Contact> officeContacts = readContactJson(OFFICE_ADDRESS_BOOK);
        officeContacts.stream().forEach(contact -> bookService.addContact(OFFICE_ADDRESSBOOK_NAME, contact));
    }


    private List<Contact> readContactJson(String fileName) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(fileName);
        InputStream inputStream = classPathResource.getInputStream();
        String valueOf = IOUtils.toString(inputStream);

        ObjectMapper mapper = new ObjectMapper();
        return Arrays.asList(mapper.readValue(valueOf, Contact[].class));

    }

}
