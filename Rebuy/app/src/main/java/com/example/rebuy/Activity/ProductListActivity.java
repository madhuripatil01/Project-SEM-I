package com.example.rebuy.Activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebuy.DataModels.ProductModel;
import com.example.rebuy.R;

import java.util.List;

public class ProductListActivity extends AppCompatActivity {
    RecyclerView recmyapp;

    private List AList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaylist_layout);
        recmyapp=findViewById(R.id.recmyapp);







    }
}
