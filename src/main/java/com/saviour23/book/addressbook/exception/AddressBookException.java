package com.saviour23.book.addressbook.exception;

/**
 * Exception for Address Book Application.
 */
public class AddressBookException extends Exception {

    public AddressBookException(String msg) {
        super(msg);
    }

    public AddressBookException(String msg, Throwable t) {
        super(msg, t);
    }
}
