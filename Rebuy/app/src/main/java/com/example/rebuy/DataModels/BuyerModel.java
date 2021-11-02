package com.example.rebuy.DataModels;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import java.io.Serializable;
@Entity
public class BuyerModel implements Serializable
{
    @PrimaryKey(autoGenerate =true)
    private int BuyerId;

    @ColumnInfo(name ="txtBuyerName")
    private String BuyerName;

    @ColumnInfo(name ="ImgBuyer")
    private byte[] ImgBuyer;

    @ColumnInfo(name = "txtBuyerAddress")
    private String BuyerAddress;

    @ColumnInfo(name = "txtBuyerContactNo")
    private String BuyerContactNo;

    @ColumnInfo(name = "txtBuyerEmail")
    private String BuyerEmail;

    @ColumnInfo(name = "txtUId")
    private String UserId;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public BuyerModel()
    {

    }

    @Ignore
    public BuyerModel(int buyerId, String buyerName, byte[] imgBuyer, String buyerAddress, String buyerContactNo, String buyerEmail) {
        BuyerId = buyerId;
        BuyerName = buyerName;
        ImgBuyer = imgBuyer;
        BuyerAddress = buyerAddress;
        BuyerContactNo = buyerContactNo;
        BuyerEmail = buyerEmail;
    }

    public int getBuyerId() {
        return BuyerId;
    }

    public void setBuyerId(int buyerId) {
        BuyerId = buyerId;
    }

    public String getBuyerName() {
        return BuyerName;
    }

    public void setBuyerName(String buyerName) {
        BuyerName = buyerName;
    }

    public byte[] getImgBuyer() {
        return ImgBuyer;
    }

    public void setImgBuyer(byte[] imgBuyer) {
        ImgBuyer = imgBuyer;
    }

    public String getBuyerAddress() {
        return BuyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        BuyerAddress = buyerAddress;
    }

    public String getBuyerContactNo() {
        return BuyerContactNo;
    }

    public void setBuyerContactNo(String buyerContactNo) {
        BuyerContactNo = buyerContactNo;
    }

    public String getBuyerEmail() {
        return BuyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        BuyerEmail = buyerEmail;
    }
}
