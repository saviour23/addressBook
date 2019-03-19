package com.saviour23.book.addressbook.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.saviour23.book.addressbook.exception.ValidationException;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * Name class for storing first and last name.
 */
public class Name implements Serializable {

    private String firstName;
    private String lastName;

    public Name() {

    }

    public Name(String firstName, String lastName) throws
            ValidationException {
        if (isValidName(firstName, lastName)) {
            this.firstName = firstName;
            this.lastName = lastName;
        } else {
            throw new ValidationException("First and last names cannot be blank");
        }

    }

    private boolean isValidName(String firstName, String lastName) {
        if (StringUtils.isEmpty(firstName) || StringUtils.isEmpty(lastName)) {
            return false;
        }
        return true;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @JsonIgnore
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void setFirstName(String firstName) {
        if (StringUtils.isEmpty(firstName)) {
            throw new ValidationException("First cannot be blank");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (StringUtils.isEmpty(lastName)) {
            throw new ValidationException("Last Name cannot be blank");
        }
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Name name = (Name) o;

        return new EqualsBuilder()
                .append(firstName, name.firstName)
                .append(lastName, name.lastName)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(firstName)
                .append(lastName)
                .toHashCode();
    }
}