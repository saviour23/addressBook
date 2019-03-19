package com.saviour23.book.addressbook.model;

import com.saviour23.book.addressbook.exception.ValidationException;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Class responsible for storing Phonenumber with type like mobile or landline
 */
public class PhoneNumber implements Serializable {

    private String mobileNumber;
    private PhoneNumberType numberType;

    public PhoneNumber(){

    }
    public PhoneNumber(String number, PhoneNumberType phoneNumbertype) {

        if (isValidPhoneNumber(number)) {
            this.mobileNumber = number;
            this.numberType = phoneNumbertype;
        } else {
            throw new ValidationException("Please enter a valid 10 digit phone number");
        }

    }

    /**
     * Validating phone number of any type, mobile and landline both are of 10 digits.
     *
     * @param phoneNumber
     * @return
     */
    private boolean isValidPhoneNumber(String phoneNumber) {
        if (!phoneNumber.matches("\\d{10}")) {
            return false;
        }
        return true;
    }


    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        if (isValidPhoneNumber(mobileNumber)) {

            this.mobileNumber = mobileNumber;
        } else {
            throw new ValidationException("Please enter a valid 10 digit phone number");
        }

    }


    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("mobileNumber", mobileNumber)
                .append("numberType", numberType)
                .toString();
    }
}


