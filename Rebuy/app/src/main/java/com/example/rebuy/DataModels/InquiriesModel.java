package com.example.rebuy.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class InquiriesModel implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    private int CustId;

    @ColumnInfo(name = "CustName")
    private String CustName;

    @ColumnInfo(name = "CustMobNo")
    private String CustMobNo;

    @ColumnInfo(name = "CustEmail")
    private String CustEmail;

    @ColumnInfo(name ="ImgCust")
    private byte[] ImgCust;

    @ColumnInfo(name ="InqProdName")
    private String InqProdName;

    public String getInqProdName() {
        return InqProdName;
    }

    public void setInqProdName(String inqProdName) {
        InqProdName = inqProdName;
    }

    public byte[] getImgCust() {
        return ImgCust;
    }

    public void setImgCust(byte[] imgCust) {
        ImgCust = imgCust;
    }

    public int getCustId() {
        return CustId;
    }

    public void setCustId(int custId) {
        CustId = custId;
    }

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String custName) {
        CustName = custName;
    }

    public String getCustMobNo() {
        return CustMobNo;
    }

    public void setCustMobNo(String custMobNo) {
        CustMobNo = custMobNo;
    }

    public String getCustEmail() {
        return CustEmail;
    }

    public void setCustEmail(String custEmail) {
        CustEmail = custEmail;
    }
}
