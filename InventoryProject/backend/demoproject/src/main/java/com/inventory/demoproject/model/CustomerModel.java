package com.inventory.demoproject.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customer")
public class CustomerModel {

    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "customer_address")
    private String customerAddress;

    @Column(name = "billing_address")
    private String billingAddress;

//    @Column(name="bill_date")
//    @Temporal(TemporalType.DATE)
//    private Date billDate;

    @Column(name = "contact_number")
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
