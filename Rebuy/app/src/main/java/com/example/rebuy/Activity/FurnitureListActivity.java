package com.example.rebuy.Activity;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebuy.Adapter.BuyerListAdapter;
import com.example.rebuy.Adapter.FurnitureAdapter;
import com.example.rebuy.DataModels.BuyerModel;
import com.example.rebuy.DataModels.OrderModel;
import com.example.rebuy.DataModels.ProductModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.RebuyDatabaseClient;

import java.util.ArrayList;
import java.util.List;

public class FurnitureListActivity extends AppCompatActivity {
    RecyclerView rec_furniture;
    FurnitureAdapter furnitureAdapter;
    private List<ProductModel> furnitureList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rec_furniture_lay);
        rec_furniture = findViewById(R.id.rec_furniture);

        if(getIntent().getStringExtra("catogoryFurniture").equals("Furniture")) {
            String strcat = getIntent().getStringExtra("catogoryFurniture");
            furnitureList = RebuyDatabaseClient.getRebuyInstance(this).getRebuyDatabase()
                    .productDAO().SelectProdByCategory(strcat);

            furnitureAdapter = new FurnitureAdapter(furnitureList, this);
            rec_furniture.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                    false));
            rec_furniture.setAdapter(furnitureAdapter);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        MenuItem menuItem=menu.findItem(R.id.action_search);
        SearchView searchView= (SearchView) menuItem.getActionView();

        searchView.setQueryHint("Search Products");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<ProductModel> PList=filter(furnitureList,newText);
                furnitureAdapter.setFilterList(PList);
                return true;
            }
        });
         return true;
    }
    private List<ProductModel> filter(List<ProductModel> furnitureList,String newText)
    {
        final  List<ProductModel> PList=new ArrayList<>();
        for (ProductModel searchproduct : furnitureList)
        {
            final String text=searchproduct.getProdName().toLowerCase();
            if (text.contains(newText))
            {

                PList.add(searchproduct);
            }
        }
        return PList;
    }

}