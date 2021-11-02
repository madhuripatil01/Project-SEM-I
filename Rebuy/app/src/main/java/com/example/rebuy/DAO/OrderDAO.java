package com.example.rebuy.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.rebuy.DataModels.OrderModel;
import com.example.rebuy.DataModels.UserModel;

import java.util.List;

@Dao
public interface OrderDAO
{
    @Query("SELECT * FROM OrderModel")
    List<OrderModel> getAllOrders();

    @Query("SELECT * FROM OrderModel")
    OrderModel AllOrders();

    @Insert
    long insertOrderModel(OrderModel orderModel);

    @Update
    void updateOrderModel(OrderModel orderModel);

    @Delete
    void  deleteOrderModel(OrderModel orderModel);

    @Query("Select * from OrderModel where OrdBuyerName=:bName")
    List<OrderModel> selectOrderByBuyerId(String bName);



}
