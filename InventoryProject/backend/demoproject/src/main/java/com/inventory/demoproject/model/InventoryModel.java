package com.inventory.demoproject.model;

import javax.persistence.*;
@Entity
@Table(name = "inventory")
public class InventoryModel {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_specification")
    private String productSpecification;

    @Column(name = "product_unit")
    private Integer productUnit;


    @Column(name = "product_hSN")
    private Integer productHSN;


    @Column(name = "product_price")
    private long productPrice;


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