package com.inventory.demoproject.controller;

import com.inventory.demoproject.dto.InventoryDto;
import com.inventory.demoproject.dto.ResponseVO;
import com.inventory.demoproject.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @RequestMapping(value = "/insertInventoryRecord",method = RequestMethod.POST)
    public ResponseVO insertInventoryRecord(@RequestBody InventoryDto inventoryDto)
    {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=inventoryService.insertController(inventoryDto);

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




    @RequestMapping(value="getInventoryRecord",method=RequestMethod.GET)
    public List getInventoryRecord()
    {
        ResponseVO  responseVO=new ResponseVO();

        List list=inventoryService.getInventoryDetails();
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


    @RequestMapping(value="getInventoryRecordProductName",method=RequestMethod.GET)
    public ResponseVO<List> getInventoryRecordProductName()
    {
//        ResponseVO  responseVO=new ResponseVO();
        ResponseVO<List> responseVO=new ResponseVO<>();
        List list=inventoryService.getInventoryDetailsProductName();


        responseVO.setResult(list);
        responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
        return responseVO;
    }


    @RequestMapping(value = "editinventoryRecordIdWise/{productId}", method = RequestMethod.POST)
    public ResponseVO<InventoryDto> editinventoryRecordIdWise(@PathVariable Integer productId) {
        ResponseVO<InventoryDto> responseVO = new ResponseVO<InventoryDto>();


        InventoryDto inventoryDto = inventoryService.getInventoryProductWiseDetailsIdwise(productId);
        if (inventoryDto!= null) {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("get Successfully");
            responseVO.setResult(inventoryDto);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Not Successfully");
            responseVO.setResult(inventoryDto);
        }
        return responseVO;
    }


    @RequestMapping(value = "deleteInventoryRecord/{productId}", method = RequestMethod.DELETE)
    public ResponseVO deleteInventoryRecord(@PathVariable Integer productId) {
        ResponseVO responseVO=new ResponseVO();
        boolean flag=inventoryService.deleteController(productId);

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



    @RequestMapping(value = "updateinventoryRecord", method = RequestMethod.POST)
    public ResponseVO updateinventoryRecord(@RequestBody InventoryDto inventoryDto)
    {
        ResponseVO responseVO = new ResponseVO();
        boolean flag = inventoryService.updateController(inventoryDto);
        if (flag == true) {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("updated sucessfully");
            responseVO.setResult(inventoryDto);
        } else {
            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("failed");
            responseVO.setResult(inventoryDto);
        }
        return responseVO;
    }


    @RequestMapping(value = "editinventoryRecordproductNames", method = RequestMethod.POST)
    public ResponseVO<InventoryDto> editinventoryRecordproductNames(@RequestBody InventoryDto inventoryDto)
    {
        ResponseVO<InventoryDto> responseVO = new ResponseVO<InventoryDto>();

           System.out.println("id"+inventoryDto.getProductId());
        InventoryDto inventoryDto2 = inventoryService.getproductwiseReportMethod(inventoryDto);
        if (inventoryDto2!= null) {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("get Successfully");
            responseVO.setResult(inventoryDto2);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Not Successfully");
            responseVO.setResult(inventoryDto2);
        }
        return responseVO;
    }




    @RequestMapping(value = "editinventoryRecordIdWiseDForTable/{productId}", method = RequestMethod.POST)
    public ResponseVO<InventoryDto> editinventoryRecordIdWiseDForTable(@PathVariable Integer productId) {
        ResponseVO<InventoryDto> responseVO = new ResponseVO<InventoryDto>();


        InventoryDto inventoryDto = inventoryService.editinventoryRecordIdWiseDForTableCon(productId);
        if (inventoryDto!= null) {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("get Successfully");
            responseVO.setResult(inventoryDto);
        }
        else
        {
            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("Not Successfully");
            responseVO.setResult(inventoryDto);
        }
        return responseVO;
    }




    @RequestMapping(value = "updateinventoryRecordfinal", method = RequestMethod.POST)
    public ResponseVO updateinventoryRecordfinal(@RequestBody InventoryDto inventoryDto)
    {
        ResponseVO responseVO = new ResponseVO();
        boolean flag = inventoryService.updateControllerfinal(inventoryDto);
        if (flag == true) {
            responseVO.setStatusCode(String.valueOf(HttpStatus.OK));
            responseVO.setMessage("updated sucessfully");
            responseVO.setResult(inventoryDto);
        } else {
            responseVO.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR));
            responseVO.setMessage("failed");
            responseVO.setResult(inventoryDto);
        }
        return responseVO;
    }
}
