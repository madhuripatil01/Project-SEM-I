package com.example.rebuy.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.rebuy.DataModels.BuyerModel;
import com.example.rebuy.DataModels.InquiriesModel;
import com.example.rebuy.DataModels.OrderModel;

import java.util.List;
@Dao
public interface InquiriesDAO {
    @Query("SELECT * FROM InquiriesModel")
    List<InquiriesModel> getAllInquiries();

    @Insert
    long insertInquiriesModel(InquiriesModel inquiriesModel);

    @Update
    void updateInquiriesModel(InquiriesModel inquiriesModel);

    @Delete
    void  deleteInquiriesModel(InquiriesModel inquiriesModel);

    @Query("Select * from InquiriesModel where InqProdName=:pName")
    List<InquiriesModel> selectInqByProdName(String pName);
}
