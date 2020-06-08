package com.inventory.demoproject.dao;


import com.inventory.demoproject.dto.CustomerDto;
import com.inventory.demoproject.model.CustomerModel;

import java.util.List;

public interface CustomerDao {
    boolean insertCustomerService(CustomerModel customerModel);

    List getCustomerDao();

    List getCustomernamesDao();

    List<CustomerModel> getcustomerWiseDaos(Integer customerId);

    boolean updateCustomerService(CustomerModel customerModel);

    boolean deleteCustomerDao(Integer customerId);

    CustomerDto getCustomerDaoid(Integer customerId);

    List getMobileDao(String contactNumber);
}
