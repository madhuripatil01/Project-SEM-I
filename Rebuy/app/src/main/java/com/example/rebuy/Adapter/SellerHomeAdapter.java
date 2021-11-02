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

import com.example.rebuy.DataModels.BuyerModel;
import com.example.rebuy.DataModels.InquiriesModel;
import com.example.rebuy.DataModels.OrderModel;
import com.example.rebuy.DataModels.UserModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.UtilityMethods;

import java.util.ArrayList;
import java.util.List;

public class SellerHomeAdapter extends RecyclerView.Adapter<SellerHomeAdapter.MyViewHolder>
{
    Context context;
    List<InquiriesModel> ProdViewList = new ArrayList<>();

    public SellerHomeAdapter(Context context, List<InquiriesModel> prodViewList) {
        this.context = context;
        ProdViewList = prodViewList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.seller_home,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        InquiriesModel inquiriesModel=ProdViewList.get(position);
        holder.ProdViewImg.setImageBitmap(UtilityMethods.imgConvertFromByteArrayToBitmap(inquiriesModel.getImgCust()));
        holder.txt_ProdViewName.setText(inquiriesModel.getCustName());
        holder.txt_ProdViewEmail.setText(inquiriesModel.getCustEmail());
        holder.txt_ProdViewmbno.setText(inquiriesModel.getCustMobNo());


    }

    @Override
    public int getItemCount() {
        return ProdViewList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ProdViewImg;
        TextView txt_ProdViewName,txt_ProdViewEmail,txt_ProdViewmbno;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           ProdViewImg=itemView.findViewById(R.id.ProdViewImg);
           txt_ProdViewName=itemView.findViewById(R.id.txt_ProdViewName);
           txt_ProdViewEmail=itemView.findViewById(R.id.txt_ProdViewEmail);
           txt_ProdViewmbno=itemView.findViewById(R.id.txt_ProdViewmbno);
        }
    }
}
