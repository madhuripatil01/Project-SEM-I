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

public class BuyerListAdapter extends RecyclerView.Adapter<BuyerListAdapter.MyViewHolder>
{
    List<BuyerModel> buyerList;
    Context context;

    public BuyerListAdapter(List<BuyerModel> buyerList, Context context) {
        this.context=context;
        this.buyerList=buyerList;
    }

    @NonNull
    @Override
    public BuyerListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BuyerListAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.admin_buyer_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final BuyerModel buyerModel=buyerList.get(position);

        holder.txtbname.setText(buyerModel.getBuyerName());
        holder.txtbemail.setText(buyerModel.getBuyerEmail());
        holder.txtbmobno.setText(buyerModel.getBuyerContactNo());
        holder.txtbaddress.setText(buyerModel.getBuyerAddress());

        holder.BuyerProImg.setImageBitmap(UtilityMethods.imgConvertFromByteArrayToBitmap
                (buyerModel.getImgBuyer()));

    }


    @Override
    public int getItemCount() {
        return buyerList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtbname,txtbemail,txtbmobno,txtbaddress;
        ImageView BuyerProImg;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtbname=itemView.findViewById(R.id.txtbname);
            txtbemail=itemView.findViewById(R.id.txtbemail);
            txtbaddress=itemView.findViewById(R.id.txtbaddress);
            txtbmobno=itemView.findViewById(R.id.txtbmobno);
            BuyerProImg=itemView.findViewById(R.id.BuyerProImg);


        }
    }
}


