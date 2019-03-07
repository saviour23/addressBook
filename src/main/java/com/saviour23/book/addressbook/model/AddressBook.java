package com.saviour23.book.addressbook.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * Address Book.
 */
public class AddressBook {

    private String id;
    private String name;
    private Map<String, Contact> contacts;


    public AddressBook() {
        this.id = UUID.randomUUID().toString();
        contacts = new ConcurrentHashMap();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Contact> getContacts() {
        return contacts;
    }


    public void setContacts(Map<String, Contact> contacts) {
        this.contacts = contacts;
    }

    /**
     * Method exposed to add the contact.
     *
     * @param contact
     */
    public void addContact(Contact contact) {
        contacts.put(contact.getId(), contact);
    }

    /**
     * method exposed to remove contact.
     *
     * @param id
     */
    public void removeContact(String id) {
        contacts.remove(id);
    }

    /**
     * Method for getting contacy by ID.
     */
    public Contact getContactById(String id) {
        return contacts.get(id);
    }


    public List<Contact> getAllContacts() {
        return contacts.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("contacts", contacts)
                .toString();
    }

}
