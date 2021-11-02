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

import com.example.rebuy.Adapter.ElectronicsAdapter;
import com.example.rebuy.Adapter.FurnitureAdapter;
import com.example.rebuy.DataModels.ProductModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.RebuyDatabaseClient;

import java.util.ArrayList;
import java.util.List;

public class ElectronicsListActivity extends AppCompatActivity {
    RecyclerView rec_electronics;
    Context context;
    ElectronicsAdapter electronicsAdapter;
    private List<ProductModel> ElectronicList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rec_electronics_lay);
        rec_electronics = findViewById(R.id.rec_electronics);

        if(getIntent().getStringExtra("catogoryElectronic").equals("Electronic")) {
            String strcat = getIntent().getStringExtra("catogoryElectronic");

            ElectronicList = RebuyDatabaseClient.getRebuyInstance(this).getRebuyDatabase()
                    .productDAO().SelectProdByCategory(strcat);


            electronicsAdapter = new ElectronicsAdapter(ElectronicList, this);
            rec_electronics.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,
                    false));
            rec_electronics.setAdapter(electronicsAdapter);
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
                final List<ProductModel> PList=filter(ElectronicList,newText);
                electronicsAdapter.setFilterList(PList);
                return true;
            }
        });
        return true;
    }
    private List<ProductModel> filter(List<ProductModel> ElectronicList,String newText)
    {
        final  List<ProductModel> PList=new ArrayList<>();
        for (ProductModel searchproduct : ElectronicList)
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