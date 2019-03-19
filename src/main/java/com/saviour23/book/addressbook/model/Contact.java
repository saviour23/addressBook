package com.saviour23.book.addressbook.model;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Contact class for storing Name and PhoneNumbers
 */
public class Contact implements Serializable {
    private Name name;
    private List<PhoneNumber> telephone;

    public Contact() {
        telephone = new ArrayList<>();
    }


    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public List<PhoneNumber> getTelephone() {
        return telephone;
    }

    public void setTelephone(List<PhoneNumber> telephone) {
        this.telephone = telephone;
    }

    public void addPhoneNumber(PhoneNumber number) {
        telephone.add(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return new EqualsBuilder()
                .append(name, contact.name)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("telephone", telephone)
                .toString();
    }
}
