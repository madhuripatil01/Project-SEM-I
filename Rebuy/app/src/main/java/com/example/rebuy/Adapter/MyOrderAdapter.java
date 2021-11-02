package com.example.rebuy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebuy.DataModels.OrderModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.Shared_Preference_Manager;
import com.example.rebuy.Utility.UtilityMethods;

import java.util.ArrayList;
import java.util.List;

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.MyViewHolder>
{
    List<OrderModel> OrderList = new ArrayList<>();
    Context context;

    public MyOrderAdapter(List<OrderModel> orderList, Context context) {
        OrderList = orderList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyOrderAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.myorder_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyOrderAdapter.MyViewHolder holder, int position)
    {

        OrderModel orderModel=OrderList.get(position);
        if(orderModel.getBuyerId()== Shared_Preference_Manager.getUser_ID(context)) {
            holder.myOrderImg.setImageBitmap(UtilityMethods.imgConvertFromByteArrayToBitmap(orderModel.getOrdImgProd()));
            holder.txt_myOrdproName.setText(orderModel.getOrdProName());
            holder.txt_myOrdproPrice.setText(orderModel.getOrdProdPrice());
            holder.txt_myOrdproCategory.setText(orderModel.getOrdProdCategory());
        }

    }

    @Override
    public int getItemCount() {
        return OrderList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView myOrderImg;
        TextView txt_myOrdproName,txt_myOrdproPrice,txt_myOrdproCategory;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myOrderImg=itemView.findViewById(R.id.myOrderImg);
            txt_myOrdproName=itemView.findViewById(R.id.txt_myOrdproName);
            txt_myOrdproPrice=itemView.findViewById(R.id.txt_myOrdproprice);
            txt_myOrdproCategory=itemView.findViewById(R.id.txt_myOrdproCategory);
        }
    }
}
