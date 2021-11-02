package com.example.rebuy.DAO;

import androidx.room.Dao;
import com.example.rebuy.DataModels.ProductModel;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ProductDAO {

    @Query("SELECT * FROM ProductModel")
    List<ProductModel> getAllProducts();

    @Insert
    long insertProductModel(ProductModel productModel);

    @Query("delete from ProductModel WHERE ProdName=:pName")
    void deleteProductModel(String pName);

   @Update
    void updateProductModel (ProductModel productModel);

    @Query("Select * from ProductModel where ProdId=:pid")
    ProductModel SelectProdById(long pid);

    @Query("Select * from  ProductModel where ProdCategory=:prodcat")
    List<ProductModel> SelectProdByCategory(String prodcat);

}
