package com.saviour23.book.addressbook.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saviour23.book.addressbook.model.AddressBookType;
import com.saviour23.book.addressbook.model.Contact;
import com.saviour23.book.addressbook.service.AddressBookService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * This is temporary component to pupulate the customerData.
 */
@Component
public class TestDataPopulation {


    @Autowired
    AddressBookService bookService;

    private static final String CONTACT_DATA_1 = "testdata/contact1.json";
    private static final String CONTACT_DATA_2 = "testdata/contact2.json";


    @PostConstruct
    private void polulateDataForTwoContacts() throws IOException {

        List<Contact> contactList = new ArrayList<>();
        contactList.add(getContactObject(CONTACT_DATA_1));
        contactList.add(getContactObject(CONTACT_DATA_2));

        contactList.forEach(contact -> bookService.addContact(AddressBookType.CUSTOMER, contact));

    }

    private Contact getContactObject(String fileName) throws IOException {
        ClassPathResource classPathResource = new ClassPathResource(fileName);
        InputStream inputStream = classPathResource.getInputStream();
        String valueOf = IOUtils.toString(inputStream);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(valueOf, Contact.class);
    }


}
