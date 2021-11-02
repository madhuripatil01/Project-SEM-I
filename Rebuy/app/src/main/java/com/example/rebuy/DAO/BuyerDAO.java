package com.example.rebuy.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.rebuy.DataModels.BuyerModel;
import com.example.rebuy.DataModels.SellerModel;

import java.util.List;

@Dao
public interface BuyerDAO {

    @Query("SELECT * FROM BuyerModel")
    List<BuyerModel> getAllBuyers();

    @Insert
    long insertBuyerModel(BuyerModel buyerModel);

    @Update
    void updateBuyerModel(BuyerModel buyerModel);

    @Delete
    void  deleteBuyerModel(BuyerModel buyerModel);

    @Query("Select * from BuyerModel where BuyerId=:bid")
    BuyerModel SelectBuyerById(long bid);

}
