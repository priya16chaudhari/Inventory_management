package com.inventory.demoproject.service.impl;


import com.inventory.demoproject.dao.CustomerDao;
import com.inventory.demoproject.dto.CustomerDto;
import com.inventory.demoproject.model.CustomerModel;
import com.inventory.demoproject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;


    @Override
    public boolean insertCustomerController(CustomerDto customerDto) {
        CustomerModel customerModel=new CustomerModel();


            customerModel.setCustomerName(customerDto.getCustomerName());

//            customerModel.setBillDate(customerDto.getBillDate());

            customerModel.setContactNumber(customerDto.getContactNumber());
            customerModel.setBillingAddress(customerDto.getBillingAddress());
            customerModel.setCustomerAddress(customerDto.getCustomerAddress());




        boolean flag=customerDao.insertCustomerService(customerModel);
        return flag;
    }

    @Override
    public List getCustomerRecordDetails() {
        List list=customerDao.getCustomerDao();
        return list;
    }

    @Override
    public List getCutomerName() {
        List list=customerDao.getCustomernamesDao();
        return list;
    }

    @Override
    public CustomerDto getCustomerDetailsIdwise(Integer customerId) {
       CustomerDto customerDto=customerDao.getCustomerDaoid(customerId);


        return customerDto;
    }

    @Override
    public boolean deleteControllerCustomer(Integer customerId) {
        boolean flag=customerDao.deleteCustomerDao(customerId);


        return flag;
    }

    @Override
    public boolean updateController(CustomerDto customerDto) {
        CustomerModel customerModel=new CustomerModel();

        customerModel.setCustomerId(customerDto.getCustomerId());
        customerModel.setCustomerName(customerDto.getCustomerName());
//        customerModel.setBillDate(customerDto.getBillDate());
        customerModel.setCustomerAddress(customerDto.getCustomerAddress());

        customerModel.setBillingAddress(customerDto.getBillingAddress());

        customerModel.setContactNumber(customerDto.getContactNumber());

        boolean flag=customerDao.updateCustomerService(customerModel);
        return flag;

    }

    @Override
    public List getCustomerwiseReportMethod(CustomerDto customerDto) {

        System.out.println("hhfhh"+customerDto.getCustomerId());
        List<CustomerModel> selectList=customerDao.getcustomerWiseDaos(customerDto.getCustomerId());


        return selectList;
    }



    @Override
    public List getMobileWiseDetails(String contactNumber) {
        List list=customerDao.getMobileDao(contactNumber);
        return list;
    }
}
