package com.inventory.demoproject.controller;

import com.inventory.demoproject.dto.CustomerDto;
import com.inventory.demoproject.dto.ResponseVO;
import com.inventory.demoproject.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/insertCustomerRecord",method = RequestMethod.POST)
    public ResponseVO insertCustomerRecord(@RequestBody CustomerDto customerDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=customerService.insertCustomerController(customerDto);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("insert Successfully");
            responseVO.setResult(flag);

        }
        else {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("failed");
            responseVO.setResult(flag);
        }
        return responseVO;

    }



    @RequestMapping(value="getCustomerRecord",method=RequestMethod.GET)
    public List getCustomerRecord()
    {
        ResponseVO  responseVO=new ResponseVO();

        List list=customerService.getCustomerRecordDetails();
        if (list!= null) {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("get Successfully");
            responseVO.setResult(list);
        }
        else

        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("failed");
            responseVO.setResult(list);
        }
        return list;
    }




    @RequestMapping(value="getCutomerName",method=RequestMethod.GET)
    public ResponseVO<List> getCutomerName()
    {
//        ResponseVO  responseVO=new ResponseVO();
        ResponseVO<List> responseVO=new ResponseVO<>();
        List list=customerService.getCutomerName();


        responseVO.setResult(list);
        responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
        return responseVO;
    }




    @RequestMapping(value = "editCustomerRecordIdWise/{customerId}", method = RequestMethod.POST)
    public ResponseVO<CustomerDto> editCustomerRecordIdWise(@PathVariable Integer customerId) {
        ResponseVO<CustomerDto> responseVO = new ResponseVO<CustomerDto>();


        CustomerDto customerDto = customerService.getCustomerDetailsIdwise(customerId);
        if (customerDto!= null) {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("get Successfully");
            responseVO.setResult(customerDto);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Not Successfully");
            responseVO.setResult(customerDto);
        }
        return responseVO;
    }


    @RequestMapping(value = "deleteCustomerRecord/{customerId}", method = RequestMethod.DELETE)
    public ResponseVO deleteCustomerRecord(@PathVariable Integer customerId) {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=customerService.deleteControllerCustomer(customerId);

        if(flag==true)
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("insert Successfully");
            responseVO.setResult(flag);

        }
        else {
            responseVO.setStatusCode(String.valueOf(org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("failed");
            responseVO.setResult(flag);
        }
        return responseVO;
    }



    @RequestMapping(value = "updateCustomerRecord", method = RequestMethod.POST)
    public ResponseVO updateCustomerRecord(@RequestBody CustomerDto customerDto)
    {
        ResponseVO responseVO = new ResponseVO();
        boolean flag = customerService.updateController(customerDto);
        if (flag == true) {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("updated sucessfully");
            responseVO.setResult(customerDto);
        } else {
            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("failed");
            responseVO.setResult(customerDto);
        }
        return responseVO;
    }


    @RequestMapping(value = "customerdetailsList", method = RequestMethod.POST)
    public ResponseVO<List> customerdetailsList(@RequestBody CustomerDto customerDto)
    {
        ResponseVO<List> responseVO = new ResponseVO<List>();

        System.out.println("id"+customerDto.getCustomerId());
       List list= customerService.getCustomerwiseReportMethod(customerDto);
        if (list!= null) {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("get Successfully");
            responseVO.setResult(list);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Not Successfully");
            responseVO.setResult(list);
        }
        return responseVO;
    }

    @RequestMapping(value = "getDetailsMobileNumberWise/{contactNumber}",method = RequestMethod.GET)
    public ResponseVO getDetailsMobileNumberWise(@PathVariable String contactNumber){

        ResponseVO responseVO=new ResponseVO();
        List list=customerService.getMobileWiseDetails(contactNumber);
        responseVO.setResult(list);
        responseVO.setMessage("list Available");
        responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
        return responseVO;
    }

}
