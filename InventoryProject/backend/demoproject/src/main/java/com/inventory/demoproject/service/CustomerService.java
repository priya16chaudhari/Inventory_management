package com.inventory.demoproject.service;

import com.inventory.demoproject.dto.CustomerDto;


import java.util.List;

public interface CustomerService {
    boolean insertCustomerController(CustomerDto customerDto);

    List getCustomerRecordDetails();

    List getCutomerName();


    CustomerDto getCustomerDetailsIdwise(Integer customerId);

    boolean deleteControllerCustomer(Integer customerId);

    boolean updateController(CustomerDto customerDto);

    List getCustomerwiseReportMethod(CustomerDto customerDto);


    List getMobileWiseDetails(String contactNumber);
}
