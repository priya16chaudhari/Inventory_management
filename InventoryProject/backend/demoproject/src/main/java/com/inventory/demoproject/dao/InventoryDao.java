package com.inventory.demoproject.dao;


import com.inventory.demoproject.dto.InventoryDto;
import com.inventory.demoproject.model.InventoryModel;

import java.util.List;

public interface InventoryDao {
    boolean insertService(InventoryModel inventoryModel);

    List getInventoryDao();



    List getInventoryDaoProductName();

    InventoryDto getInventoryProductDaoid(Integer productId);

    boolean updateService(InventoryModel inventoryModel);

    boolean deleteInventoryProductDao(Integer productId);
//
//    List<InventoryModel> getproductWiseDao(InventoryDto inventoryDto);

    InventoryDto getproductWiseDaos(Integer productId);


    InventoryDto getInventoryProductDaoidDao(Integer productId);
}
