package com.example.rebuy.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;


@Entity
public class ProductModel implements Serializable
{
    @PrimaryKey(autoGenerate =true)
    private int ProdId;

    @ColumnInfo(name ="ProdName")
    private String ProdName;

    @ColumnInfo(name = "ProdCategory")
    private String ProdCategory;

    @ColumnInfo(name ="ImgProd")
    private byte[] ImgProd;

    @ColumnInfo(name = "txtProdPrice")
    private String ProdPrice;

    @ColumnInfo(name ="txtProdDetails")
    private String ProdDetails;

    @ColumnInfo(name ="txtSellerName")
    private String SellerName;


    public ProductModel()
    {

    }

    @Ignore
    public ProductModel(int prodId, String prodName, String prodCategory, String prodPrice, byte[] imgProd) {
        ProdId = prodId;
        ProdName = prodName;
        ProdCategory = prodCategory;
        ProdPrice = prodPrice;
        ImgProd = imgProd;
    }

    public String getSellerName() {
        return SellerName;
    }

    public void setSellerName(String sellerName) {
        SellerName = sellerName;
    }

    public void setProdId(int prodId) {
        ProdId = prodId;
    }

    public void setProdName(String prodName) {
        ProdName = prodName;
    }

    public void setProdCategory(String prodCategory) {
        ProdCategory = prodCategory;
    }

    public void setImgProd(byte[] imgProd) {
        ImgProd = imgProd;
    }

    public void setProdPrice(String prodPrice) {
        ProdPrice = prodPrice;
    }

    public int getProdId() {
        return ProdId;
    }

    public String getProdName() {
        return ProdName;
    }

    public String getProdCategory() {
        return ProdCategory;
    }

    public byte[] getImgProd() {
        return ImgProd;
    }

    public String getProdPrice() {
        return ProdPrice;
    }


    public String getProdDetails() {
        return ProdDetails;
    }

    public void setProdDetails(String prodDetails) {
        ProdDetails = prodDetails;
    }
}
