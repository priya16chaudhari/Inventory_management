package com.inventory.demoproject.service;


import com.inventory.demoproject.dto.InventoryDto;

import java.util.List;

public interface InventoryService {
    boolean insertController(InventoryDto inventoryDto);

    List getInventoryDetails();

//    List getInventoryProductWiseDetails(String productName);

    List getInventoryDetailsProductName();

    InventoryDto getInventoryProductWiseDetailsIdwise(Integer productId);

    boolean updateController(InventoryDto inventoryDto);

    boolean deleteController(Integer productId);

    InventoryDto getproductwiseReportMethod(InventoryDto inventoryDto);

    InventoryDto editinventoryRecordIdWiseDForTableCon(Integer productId);

    boolean updateControllerfinal(InventoryDto inventoryDto);
}
