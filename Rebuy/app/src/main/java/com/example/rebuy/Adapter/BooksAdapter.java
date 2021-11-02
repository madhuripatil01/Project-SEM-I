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

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.MyViewHolder>
{
    List<ProductModel> BookList;
    Context context;



    public BooksAdapter(List<ProductModel> BookList, Context context) {
        this.BookList = BookList;
        this.context = context;

    }



    @NonNull
    @Override
    public BooksAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BooksAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.bookslist_lay,parent,false));
    }


    public void setFilterList(List<ProductModel> pList)
    {
        BookList=pList;
        notifyDataSetChanged();
    }
    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.MyViewHolder holder, int position) {
        final ProductModel productModel=BookList.get(position);

        holder.txtbookname.setText(productModel.getProdName());
        holder.txtbookprice.setText(productModel.getProdPrice());


        holder.img_book.setImageBitmap(UtilityMethods.imgConvertFromByteArrayToBitmap
                (productModel.getImgProd()));
        holder.img_book.setOnClickListener(new View.OnClickListener() {
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
        return BookList.size();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtbookname,txtbookprice;
        ImageView img_book;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

           txtbookname=itemView.findViewById(R.id.txtbookname);
           txtbookprice=itemView.findViewById(R.id.txtbookprice);
            img_book=itemView.findViewById(R.id.img_book);


        }
    }
}


