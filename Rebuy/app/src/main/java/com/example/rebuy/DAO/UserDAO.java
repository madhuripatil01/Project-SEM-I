package com.example.rebuy.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
import com.example.rebuy.DataModels.UserModel;

@Dao
public interface UserDAO {
  @Query("SELECT * FROM UserModel")
  List<UserModel> getAllUsers();

  @Insert
  long insertUserModel(UserModel U);


  @Query("Update Usermodel SET UserPasswd=:newpassword  WHERE UserEmail =:email")
  void Update(String newpassword,String email);
  @Delete
  void  deleteUserModel(UserModel U);

  @Query("Select * from UserModel WHERE UserEmail=:email and UserPasswd=:pass")
  UserModel  userLogin(String email,String pass);


  @Query("Select * from UserModel where UserId=:uId")
  UserModel selectUserById(long uId);

}