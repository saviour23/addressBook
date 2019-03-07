package com.saviour23.book.addressbook.model;

import org.apache.commons.lang.builder.ToStringBuilder;

public class PhoneNumber {

    private String mobileNumber;
    private PhoneNumberType numberType;

    public PhoneNumber(){

    }
    public PhoneNumber(String number, PhoneNumberType phoneNumbertype) {
        this.mobileNumber = number;
        this.numberType = phoneNumbertype;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }




    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("mobileNumber", mobileNumber)
                .append("numberType", numberType)
                .toString();
    }
}


