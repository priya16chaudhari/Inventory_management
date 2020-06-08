package com.inventory.demoproject.dto;



import com.inventory.demoproject.model.InventoryModel;

import java.util.List;

public class InventoryDto {
    private Integer productId;
    private String productName;
    private String productSpecification;
    private Integer productUnit;
    private Integer productHSN;
    private long productPrice;
    private List<InventoryModel> detailList;
    private InventoryDto inventoryDto;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(String productSpecification) {
        this.productSpecification = productSpecification;
    }

    public Integer getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(Integer productUnit) {
        this.productUnit = productUnit;
    }

    public Integer getProductHSN() {
        return productHSN;
    }

    public void setProductHSN(Integer productHSN) {
        this.productHSN = productHSN;
    }

    public List<InventoryModel> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<InventoryModel> detailList) {
        this.detailList = detailList;
    }


    public InventoryDto getInventoryDto() {
        return inventoryDto;
    }

    public void setInventoryDto(InventoryDto inventoryDto) {
        this.inventoryDto = inventoryDto;
    }

//    public Double getProductPrice() {
//        return productPrice;
//    }
//
//    public void setProductPrice(Double productPrice) {
//        this.productPrice = productPrice;
//    }


    public long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(long productPrice) {
        this.productPrice = productPrice;
    }
}