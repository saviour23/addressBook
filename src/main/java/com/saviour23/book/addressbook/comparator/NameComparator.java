package com.saviour23.book.addressbook.comparator;

import com.saviour23.book.addressbook.model.Contact;

import java.util.Comparator;

/**
 * Comparator for sorting based on fullname.
 */
public class NameComparator implements Comparator<Contact> {

    @Override
    public int compare(Contact c1, Contact c2) {

        return c1.getName().getFullName().compareTo(c2.getName().getFullName());
    }
}
