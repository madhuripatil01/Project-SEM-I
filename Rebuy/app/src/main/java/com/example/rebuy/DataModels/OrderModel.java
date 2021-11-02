package com.example.rebuy.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class OrderModel implements Serializable
{
    @PrimaryKey(autoGenerate =true)
    private int OrderId;

   @ColumnInfo(name="txtOrdProdName")
    private String OrdProName;

    @ColumnInfo(name="txtOrdBuyerMobNo")
    private String OrdBuyerMobNo;

    @ColumnInfo(name = "txtOrdBAddress")
    private String OrdBuyerAddress;

    @ColumnInfo(name = "txtOrdPincode")
    private String OrdBuyerPincode;

    @ColumnInfo(name = "OrdBuyerName")
    private String OrdBuyerName;

    @ColumnInfo(name = "txtOrdDate")
    private String OrdDate;

    @ColumnInfo(name = "txtOrdProdPrice")
    private String OrdProdPrice;

    @ColumnInfo(name = "OrdProdCategory")
    private String OrdProdCategory;

    @ColumnInfo(name ="OrdImgProd")
    private byte[] OrdImgProd;

    @ColumnInfo(name ="SellerName")
    private String SellerName;

    @ColumnInfo(name = "isSold")
    private boolean isSold=false;

    @ColumnInfo(name = "ProdId")
    private long ProdId;

    @ColumnInfo(name = "BuyerId")
    private long BuyerId;

    public long getBuyerId() {
        return BuyerId;
    }

    public void setBuyerId(long buyerId) {
        BuyerId = buyerId;
    }

    public OrderModel()
    {

    }

    public String getSellerName() {
        return SellerName;
    }

    public void setSellerName(String sellerName) {
        SellerName = sellerName;
    }

    @Ignore
    public OrderModel(String ordProName, String ordBuyerMobNo, String ordBAddress, String ordBPincode) {
        OrdProName = ordProName;
        OrdBuyerMobNo = ordBuyerMobNo;
        OrdBuyerAddress = ordBAddress;
        OrdBuyerPincode = ordBPincode;
    }

    public long getProdId() {
        return ProdId;
    }

    public void setProdId(long prodId) {
        ProdId = prodId;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public String getOrdProdPrice() {
        return OrdProdPrice;
    }

    public void setOrdProdPrice(String ordProdPrice) {
        OrdProdPrice = ordProdPrice;
    }

    public String getOrdBuyerName() {
        return OrdBuyerName;
    }

    public void setOrdBuyerName(String ordBuyerName) {
        OrdBuyerName = ordBuyerName;
    }

    public String getOrdDate() {
        return OrdDate;
    }

    public void setOrdDate(String ordDate) {
        OrdDate = ordDate;
    }

    public String getOrdProName() {
        return OrdProName;
    }

    public void setOrdProName(String ordProName) {
        OrdProName = ordProName;
    }

    public String getOrdBuyerMobNo() {
        return OrdBuyerMobNo;
    }

    public void setOrdBuyerMobNo(String ordBuyerMobNo) {
        OrdBuyerMobNo = ordBuyerMobNo;
    }

    public String getOrdBuyerAddress() {
        return OrdBuyerAddress;
    }

    public void setOrdBuyerAddress(String ordBAddress) {
        OrdBuyerAddress = ordBAddress;
    }

    public String getOrdBuyerPincode() {
        return OrdBuyerPincode;
    }

    public void setOrdBuyerPincode(String ordBPincode) {
        OrdBuyerPincode = ordBPincode;
    }

    public int getOrderId() {
        return OrderId;
    }

    public void setOrderId(int orderId) {
        OrderId = orderId;
    }

    public String getOrdProdCategory() {
        return OrdProdCategory;
    }

    public void setOrdProdCategory(String ordProdCategory) {
        OrdProdCategory = ordProdCategory;
    }

    public byte[] getOrdImgProd() {
        return OrdImgProd;
    }

    public void setOrdImgProd(byte[] ordImgProd) {
        OrdImgProd = ordImgProd;
    }
}
