package com.example.rebuy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebuy.Activity.BuyProduct;
import com.example.rebuy.DataModels.OrderModel;
import com.example.rebuy.DataModels.ProductModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.Shared_Preference_Manager;
import com.example.rebuy.Utility.UtilityMethods;

import java.util.ArrayList;
import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.MyViewHolder>
{
   Context context;
    List<ProductModel>ProdList = new ArrayList<>();

    public ItemListAdapter(Context context, List<ProductModel> prodList) {
        this.context = context;
        ProdList = prodList;
    }

    @NonNull
    @Override
    public ItemListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemListAdapter.MyViewHolder holder, int position)
    {
        final ProductModel productModel=ProdList.get(position);
        holder.txtproname.setText(productModel.getProdName());
        holder.txtproprice.setText(productModel.getProdPrice());
        holder.BuyerHomeproImg.setImageBitmap(UtilityMethods.imgConvertFromByteArrayToBitmap(productModel.getImgProd()));
        //Toast.makeText(context, productModel.getProdName(), Toast.LENGTH_SHORT).show();
        holder.BuyerHomeproImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, BuyProduct.class);
                intent.putExtra("ProdInfo",productModel);
                context.startActivity(intent);


                //.add(Shared_Preference_Manager.getUser_ID(context));
                SharedPreferences sharedPreferences= context.getSharedPreferences("MyPref",0);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putLong("UserId", Shared_Preference_Manager.getUser_ID(context));
                editor.commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return ProdList.size();
    }

    public void setFilterList(List<ProductModel> pList)
    {
        ProdList=pList;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtproname,txtproprice;
        ImageView BuyerHomeproImg;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtproname=itemView.findViewById(R.id.txtproname);
            txtproprice=itemView.findViewById(R.id.txtproprice);
            BuyerHomeproImg=itemView.findViewById(R.id.BuyerHomeproImg);

        }
    }
}
