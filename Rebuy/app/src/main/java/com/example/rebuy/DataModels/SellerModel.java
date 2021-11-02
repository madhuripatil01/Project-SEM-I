package com.example.rebuy.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class SellerModel implements Serializable
{
    @PrimaryKey(autoGenerate =true)
    private int SellerId;

    @ColumnInfo(name ="txtSellerName")
    private String SellerName;

    @ColumnInfo(name = "txtSellerContactNo")
    private String SellerContactNo;

    @ColumnInfo(name ="ImgSeller")
    private byte[] ImgSeller;

    @ColumnInfo(name = "txtSellerEmail")
    private String SellerEmail;

    @ColumnInfo(name = "txtSellerAddress")
    private String SellerAddress;

    @ColumnInfo(name = "ProdId")
    private long ProdId;
    public SellerModel()
    {

    }

    @Ignore
    public SellerModel(int sellerId, String sellerName, String sellerContactNo, byte[] imgSeller, String sellerEmail, String sellerAddress)
    {
        SellerId = sellerId;
        SellerName = sellerName;
        SellerContactNo = sellerContactNo;
        ImgSeller = imgSeller;
        SellerEmail = sellerEmail;
        SellerAddress = sellerAddress;
    }

    public long getProdId() {
        return ProdId;
    }

    public void setProdId(long prodId) {
        ProdId = prodId;
    }

    public void setSellerId(int sellerId) {
        SellerId = sellerId;
    }

    public void setSellerName(String sellerName) {
        SellerName = sellerName;
    }

    public void setSellerContactNo(String sellerContactNo) {
        SellerContactNo = sellerContactNo;
    }

    public void setImgSeller(byte[] imgSeller) {
        ImgSeller = imgSeller;
    }

    public void setSellerEmail(String sellerEmail) {
        SellerEmail = sellerEmail;
    }

    public void setSellerAddress(String sellerAddress) {
        SellerAddress = sellerAddress;
    }

    public int getSellerId() {
        return SellerId;
    }

    public String getSellerName() {
        return SellerName;
    }

    public String getSellerContactNo() {
        return SellerContactNo;
    }

    public byte[] getImgSeller() {
        return ImgSeller;
    }

    public String getSellerEmail() {
        return SellerEmail;
    }

    public String getSellerAddress() {
        return SellerAddress;
    }


}
