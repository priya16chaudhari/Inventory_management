package com.inventory.demoproject.dto;


import com.inventory.demoproject.model.CustomerModel;
import com.inventory.demoproject.model.InventoryModel;

import java.util.List;

public class ProductDto {

    private List<InventoryModel> detailList;

    private List<CustomerModel> detailListCustomer;

    private InventoryDto inventoryDto;

    public InventoryDto getInventoryDto() {
        return inventoryDto;
    }

    public void setInventoryDto(InventoryDto inventoryDto) {
        this.inventoryDto = inventoryDto;
    }

    public List<InventoryModel> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<InventoryModel> detailList) {
        this.detailList = detailList;
    }

    public List<CustomerModel> getDetailListCustomer() {
        return detailListCustomer;
    }

    public void setDetailListCustomer(List<CustomerModel> detailListCustomer) {
        this.detailListCustomer = detailListCustomer;
    }
}
