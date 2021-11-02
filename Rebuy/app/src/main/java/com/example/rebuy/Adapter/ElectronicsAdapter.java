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

public class ElectronicsAdapter extends RecyclerView.Adapter<ElectronicsAdapter.MyViewHolder>
{
    List<ProductModel> ElectonicsList;
    Context context;



    public ElectronicsAdapter(List<ProductModel> ElectronicsList, Context context) {
        this.ElectonicsList = ElectronicsList;
        this.context = context;

    }



    @NonNull
    @Override
    public ElectronicsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ElectronicsAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.electronicslist_lay,parent,false));
    }


    public void setFilterList(List<ProductModel> pList)
    {
        ElectonicsList=pList;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull ElectronicsAdapter.MyViewHolder holder, int position) {
        final ProductModel productModel=ElectonicsList.get(position);

        holder.txtelecname.setText(productModel.getProdName());
        holder.txtelecprice.setText(productModel.getProdPrice());


        holder.img_ele.setImageBitmap(UtilityMethods.imgConvertFromByteArrayToBitmap
                (productModel.getImgProd()));
        holder.img_ele.setOnClickListener(new View.OnClickListener() {
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
       return ElectonicsList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtelecname,txtelecprice;
        ImageView img_ele;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtelecname=itemView.findViewById(R.id.txtelecname);
           txtelecprice=itemView.findViewById(R.id.txtelecprice);
            img_ele=itemView.findViewById(R.id.img_elec);


        }
    }
}


