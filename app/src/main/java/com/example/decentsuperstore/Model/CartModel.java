package com.example.decentsuperstore.Model;

import androidx.room.Entity;

@Entity
public class CartModel {

    public int ProductImage;
    public String ProductName;
    public String ProductWeight;
    public String ProductPrice;

    public CartModel(int productImage, String productName, String productWeight, String productPrice) {
        ProductImage = productImage;
        ProductName = productName;
        ProductWeight = productWeight;
        ProductPrice = productPrice;
    }


    public int getProductImage() {
        return ProductImage;
    }

    public void setProductImage(int productImage) {
        ProductImage = productImage;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getProductWeight() {
        return ProductWeight;
    }

    public void setProductWeight(String productWeight) {
        ProductWeight = productWeight;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }


}



