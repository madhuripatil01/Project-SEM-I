package com.example.rebuy.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebuy.DataModels.OrderModel;
import com.example.rebuy.DataModels.ProductModel;
import com.example.rebuy.DataModels.UserModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.RebuyDatabaseClient;
import com.example.rebuy.Utility.Shared_Preference_Manager;
import com.example.rebuy.Utility.UtilityMethods;

public class Status_Frag extends Fragment {
    Context context;
    RecyclerView recview;
    ImageView StatusProdImg;
    TextView txtStatusProdName,txtStatusProdPrice,txtStatusProdCategories,txtStatusBuyName,txtStatusBuyAddress,txtStatusBuyConNo;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.seller_status,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        StatusProdImg=view.findViewById(R.id.StatusProdImg);
        txtStatusProdName=view.findViewById(R.id.txtStatusProdName);
        txtStatusProdPrice=view.findViewById(R.id.txtStatusProdPrice);
        txtStatusProdCategories=view.findViewById(R.id.txtStatusProdCategories);
        txtStatusBuyName=view.findViewById(R.id.txtStatusBuyName);
        txtStatusBuyConNo=view.findViewById(R.id.txtStatusBuyConNo);
        txtStatusBuyAddress=view.findViewById(R.id.txtStatusBuyAddress);

        OrderModel orderModel= RebuyDatabaseClient.getRebuyInstance(context)
                .getRebuyDatabase().orderDAO().AllOrders();
        SharedPreferences sharedPreferences1 = context.getSharedPreferences("MyPref3", 0);
        SharedPreferences.Editor editor = sharedPreferences1.edit();
        editor.putString("ProdName",orderModel.getOrdProName());
        editor.commit();
//        ProductModel productModel=RebuyDatabaseClient.getRebuyInstance(context)
//                .getRebuyDatabase().productDAO().SelectProdById(orderModel.getProdId());
        SharedPreferences sharedPreferences=context.getSharedPreferences("MyPref",0);
        String Sname=sharedPreferences.getString("SellerName","");
        //Toast.makeText(context, , Toast.LENGTH_SHORT).show();
          if(orderModel.isSold()==true)
          {
              try {
                  UserModel userModel = RebuyDatabaseClient.getRebuyInstance(context)
                          .getRebuyDatabase().userDAO().selectUserById(Shared_Preference_Manager.getUser_ID(context));
                  if (orderModel.getSellerName().equals(Sname)) {

                      txtStatusBuyName.setText(orderModel.getOrdBuyerName());
                      txtStatusBuyAddress.setText(orderModel.getOrdBuyerAddress());
                      txtStatusBuyConNo.setText(orderModel.getOrdBuyerMobNo());
                      txtStatusProdName.setText(orderModel.getOrdProName());
                      txtStatusProdPrice.setText(orderModel.getOrdProdPrice());
                      txtStatusProdCategories.setText(orderModel.getOrdProdCategory());
                      StatusProdImg.setImageBitmap(UtilityMethods.imgConvertFromByteArrayToBitmap(orderModel.getOrdImgProd()));

                  }
              }
              catch(Exception e)
              {
                  Toast.makeText(context, "Please Add Product to view Status!", Toast.LENGTH_SHORT).show();
              }
          }


    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
