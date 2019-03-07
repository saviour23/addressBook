package com.saviour23.book.addressbook.model;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.List;

public class Contact {

    private String id;
    private String name;
    private List<PhoneNumber> telephone;

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

    public List<PhoneNumber> getTelephone() {
        return telephone;
    }

    public void setTelephone(List<PhoneNumber> telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("name", name)
                .append("telephone", telephone)
                .toString();
    }
}
