package com.inventory.demoproject.dto;

import java.util.Date;

public class CustomerDto {


    private Integer customerId;

    private String customerName;

    private String customerAddress;

    private String billingAddress;

//
//    private Date billDate;

    private String contactNumber;


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

//    public Date getBillDate() {
//        return billDate;
//    }
//
//    public void setBillDate(Date billDate) {
//        this.billDate = billDate;
//    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
