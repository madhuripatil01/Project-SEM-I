package com.example.rebuy.Utility;

import androidx.room.Database;
import androidx.room.RoomDatabase;


import com.example.rebuy.DAO.InquiriesDAO;
import com.example.rebuy.DAO.OrderDAO;
import com.example.rebuy.DAO.ProductDAO;
import com.example.rebuy.DAO.SellerDAO;
import com.example.rebuy.DAO.UserDAO;
import com.example.rebuy.DataModels.BuyerModel;
import com.example.rebuy.DataModels.InquiriesModel;
import com.example.rebuy.DataModels.OrderModel;
import com.example.rebuy.DataModels.ProductModel;
import com.example.rebuy.DataModels.SellerModel;
import com.example.rebuy.DataModels.UserModel;
import com.example.rebuy.DAO.BuyerDAO;

@Database(entities={BuyerModel.class, OrderModel.class, ProductModel.class, SellerModel.class,UserModel.class, InquiriesModel.class},version =2,exportSchema = false)
public abstract class RebuyDatabase extends RoomDatabase
{
    public  abstract BuyerDAO buyerDAO();
    public abstract OrderDAO orderDAO();
    public abstract ProductDAO productDAO();
    public abstract SellerDAO sellerDAO();
    public abstract UserDAO userDAO();
    public abstract InquiriesDAO inquiriesDAO();
}

