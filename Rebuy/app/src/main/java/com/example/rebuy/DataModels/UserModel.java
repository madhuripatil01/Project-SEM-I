package com.example.rebuy.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class UserModel implements Serializable {


    @PrimaryKey(autoGenerate = true)
    private int UserId;

    @ColumnInfo(name = "UserName")
    private String UserName;


    @ColumnInfo(name = "UserMobNo")
    private String UserMobNo;

    @ColumnInfo(name = "usertype")
    private String usertype;

    @ColumnInfo(name = "UserEmail")
    private String UserEmail;

    @ColumnInfo(name = "UserPasswd")
    private String UserPasswd;

    @Ignore
    public UserModel(int userId, String userName, String userMobNo, String userEmail, String userPasswd) {
        UserId = userId;
        UserName = userName;
        UserMobNo = userMobNo;
        UserEmail = userEmail;
        UserPasswd = userPasswd;
    }

    public UserModel() {

    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setUserMobNo(String userMobNo) {
        UserMobNo = userMobNo;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public void setUserPasswd(String userPasswd) {
        UserPasswd = userPasswd;
    }

    public int getUserId() {
        return UserId;
    }

    public String getUserName() {
        return UserName;
    }

    public String getUserMobNo() {
        return UserMobNo;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public String getUserPasswd() {
        return UserPasswd;
    }


    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

}

