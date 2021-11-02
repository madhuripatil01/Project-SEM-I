package com.example.rebuy.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.rebuy.DataModels.ProductModel;
import com.example.rebuy.DataModels.SellerModel;

import java.util.List;

@Dao
public interface SellerDAO {

    @Query("SELECT * FROM SellerModel")
    List<SellerModel> getAllSellers();

    @Insert
    long insertSellerModel(SellerModel sellerModel);

    @Update
    void updateSellerModel(SellerModel sellerModel);

    @Delete
    void  deleteSellerModel(SellerModel sellerModel);

    @Query("Select * from SellerModel where SellerId=:sid")
    SellerModel SelectSellerById(long sid);

}
