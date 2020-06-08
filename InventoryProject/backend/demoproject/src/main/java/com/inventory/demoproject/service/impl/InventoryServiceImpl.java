package com.inventory.demoproject.service.Impl;


import com.inventory.demoproject.dao.InventoryDao;
import com.inventory.demoproject.dto.InventoryDto;
import com.inventory.demoproject.model.InventoryModel;
import com.inventory.demoproject.service.InventoryService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InventoryServiceImpl implements InventoryService {


    @Autowired
    private InventoryDao inventoryDao;


    @Override
    public boolean insertController(InventoryDto inventoryDto) {

        InventoryModel inventoryModel=new InventoryModel();


        inventoryModel.setProductName(inventoryDto.getProductName());
        inventoryModel.setProductSpecification(inventoryDto.getProductSpecification());
        inventoryModel.setProductUnit(inventoryDto.getProductUnit());
        inventoryModel.setProductHSN(inventoryDto.getProductHSN());
        inventoryModel.setProductPrice(inventoryDto.getProductPrice());





        boolean flag=inventoryDao.insertService(inventoryModel);
        return flag;

    }

    @Override
    public List getInventoryDetails() {
        List list=inventoryDao.getInventoryDao();
        return list;
    }

//    @Override
//    public List getInventoryProductWiseDetails(String productName) {
//
//            List list=inventoryDao.getInventoryProductDao(productName);
//
//
//            return list;
//
//
//
//    }

    @Override
    public List getInventoryDetailsProductName() {
        List list=inventoryDao.getInventoryDaoProductName();
        return list;
    }

    @Override
    public InventoryDto getInventoryProductWiseDetailsIdwise(Integer productId) {
        InventoryDto inventoryDto=inventoryDao.getInventoryProductDaoid(productId);


        return inventoryDto;
    }

    @Override
    public boolean updateController(InventoryDto inventoryDto) {



        InventoryModel inventoryModel=new InventoryModel();

        inventoryModel.setProductId(inventoryDto.getProductId());
        inventoryModel.setProductName(inventoryDto.getProductName());
        inventoryModel.setProductSpecification(inventoryDto.getProductSpecification());
        inventoryModel.setProductUnit(inventoryDto.getProductUnit());
        inventoryModel.setProductHSN(inventoryDto.getProductHSN());
        inventoryModel.setProductPrice(inventoryDto.getProductPrice());


        boolean flag=inventoryDao.updateService(inventoryModel);
        return flag;

    }

    @Override
    public boolean deleteController(Integer productId) {
        boolean flag=inventoryDao.deleteInventoryProductDao(productId);


        return flag;
    }

    @Override
    public InventoryDto getproductwiseReportMethod(InventoryDto inventoryDto) {


        System.out.println("hhfhh"+inventoryDto.getProductId());
      InventoryDto inventoryDto1=inventoryDao.getproductWiseDaos(inventoryDto.getProductId());

//        ProductDto productDto=new ProductDto();
//        productDto.setDetailList(selectList);
        return inventoryDto1;
    }

    @Override
    public InventoryDto editinventoryRecordIdWiseDForTableCon(Integer productId) {
        InventoryDto inventoryDto=inventoryDao.getInventoryProductDaoidDao(productId);


        return inventoryDto;
    }

    @Override
    public boolean updateControllerfinal(InventoryDto inventoryDto) {

        InventoryModel inventoryModel=new InventoryModel();

        inventoryModel.setProductId(inventoryDto.getProductId());
        inventoryModel.setProductName(inventoryDto.getProductName());
        inventoryModel.setProductSpecification(inventoryDto.getProductSpecification());
        inventoryModel.setProductUnit(inventoryDto.getProductUnit());
        inventoryModel.setProductHSN(inventoryDto.getProductHSN());
        inventoryModel.setProductPrice(inventoryDto.getProductPrice());


        boolean flag=inventoryDao.updateService(inventoryModel);
        return flag;
    }
}
