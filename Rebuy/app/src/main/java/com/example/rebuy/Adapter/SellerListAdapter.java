package com.example.rebuy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebuy.DataModels.BuyerModel;
import com.example.rebuy.DataModels.SellerModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.UtilityMethods;

import java.util.List;

public class SellerListAdapter extends RecyclerView.Adapter<SellerListAdapter.MyViewHolder>
{
    List<SellerModel> sellerList;
    Context context;



    public SellerListAdapter(List<SellerModel> sellerList, Context context) {
        this.sellerList = sellerList;
        this.context = context;

    }


    @NonNull
    @Override
    public SellerListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SellerListAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.admin_seller_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final SellerModel sellerModel=sellerList.get(position);

        holder.txtsname.setText(sellerModel.getSellerName());
        holder.txtsemail.setText(sellerModel.getSellerEmail());
        holder.txtsmobno.setText(sellerModel.getSellerContactNo());
        holder.txtsaddress.setText(sellerModel.getSellerAddress());

        holder.imgseller.setImageBitmap(UtilityMethods.imgConvertFromByteArrayToBitmap
                (sellerModel.getImgSeller()));



    }

    @Override
    public int getItemCount() {
       return sellerList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtsname,txtsemail,txtsmobno,txtsaddress;
        ImageView imgseller;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtsname=itemView.findViewById(R.id.txtsname);
            txtsemail=itemView.findViewById(R.id.txtsemail);
            txtsaddress=itemView.findViewById(R.id.txtsaddress);
            txtsmobno=itemView.findViewById(R.id.txtsmbno);
            imgseller=itemView.findViewById(R.id.sellerimg);


        }
    }
}

