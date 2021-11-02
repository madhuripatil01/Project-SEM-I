package com.example.rebuy.Adapter;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.UserHandle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebuy.Activity.BuyProduct;
import com.example.rebuy.DataModels.ProductModel;

import com.example.rebuy.DataModels.UserModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.Shared_Preference_Manager;
import com.example.rebuy.Utility.UtilityMethods;

import java.util.ArrayList;
import java.util.List;

public class FurnitureAdapter extends RecyclerView.Adapter<FurnitureAdapter.MyViewHolder>
{
    List<ProductModel> FurnitureList;
    Context context;
    static ArrayList userIdList=new ArrayList();



    public FurnitureAdapter(List<ProductModel> FurnitureList, Context context) {
        this.FurnitureList = FurnitureList;
        this.context = context;

    }


    @NonNull
    @Override
    public FurnitureAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FurnitureAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.furniturelist_lay,parent
                ,false));
    }

    public void setFilterList(List<ProductModel> pList)
    {
        FurnitureList=pList;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ProductModel productModel=FurnitureList.get(position);

        holder.txtfunname.setText(productModel.getProdName());
        holder.txtfunprice.setText(productModel.getProdPrice());


        holder.imgfun.setImageBitmap(UtilityMethods.imgConvertFromByteArrayToBitmap
                (productModel.getImgProd()));
        holder.imgfun.setOnClickListener(new View.OnClickListener() {
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

        return FurnitureList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtfunname,txtfunprice;
        ImageView imgfun;
        CardView cardviewFun;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtfunname=itemView.findViewById(R.id.txtfunname);
            txtfunprice=itemView.findViewById(R.id.txtfunprice);
            imgfun=itemView.findViewById(R.id.img_fun);
            cardviewFun=itemView.findViewById(R.id.cardviewFun);
            cardviewFun.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(context, BuyProduct.class);

        }
    }
}

