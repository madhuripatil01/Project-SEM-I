package com.example.rebuy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebuy.Activity.BuyProduct;
import com.example.rebuy.DataModels.ProductModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.UtilityMethods;

import java.util.List;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.MyViewHolder>
{
    List<ProductModel> VehicleList;
    Context context;



    public VehicleAdapter(List<ProductModel> VehicleList, Context context) {
        this.VehicleList = VehicleList;
        this.context = context;

    }



    @NonNull
    @Override
    public VehicleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VehicleAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.vehicleslist_lay,parent,false));
    }

    public void setFilterList(List<ProductModel> pList)
    {
        VehicleList=pList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleAdapter.MyViewHolder holder, int position) {
        final ProductModel productModel=VehicleList.get(position);

        holder.txtvehname.setText(productModel.getProdName());
        holder.txtvehprice.setText(productModel.getProdPrice());


        holder.img_veh.setImageBitmap(UtilityMethods.imgConvertFromByteArrayToBitmap
                (productModel.getImgProd()));

         holder.img_veh.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent=new Intent(context, BuyProduct.class);
                 intent.putExtra("ProdInfo",productModel);
                 context.startActivity(intent);
             }
         });

    }

    @Override
    public int getItemCount() {
        return VehicleList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtvehname,txtvehprice;
        ImageView img_veh;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

           txtvehname=itemView.findViewById(R.id.txtvehname);
           txtvehprice=itemView.findViewById(R.id.txtvehprice);
           img_veh=itemView.findViewById(R.id.img_veh);


        }
    }
}


