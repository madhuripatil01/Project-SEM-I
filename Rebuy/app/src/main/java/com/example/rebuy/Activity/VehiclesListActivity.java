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

import com.example.rebuy.Adapter.VehicleAdapter;
import com.example.rebuy.DataModels.ProductModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.RebuyDatabaseClient;

import java.util.ArrayList;
import java.util.List;

public class VehiclesListActivity extends AppCompatActivity {
    RecyclerView rec_vehicles;
    VehicleAdapter vehicleAdapter;
    Context context;
    private List<ProductModel> VehicleList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rec_vehicles_lay);
        rec_vehicles = findViewById(R.id.rec_vehicles);



        if(getIntent().getStringExtra("catogoryVehicle").equals("Vehicle")) {
            String strcat = getIntent().getStringExtra("catogoryVehicle");

            VehicleList = RebuyDatabaseClient.getRebuyInstance(this).getRebuyDatabase()
                    .productDAO().SelectProdByCategory(strcat);

            vehicleAdapter = new VehicleAdapter(VehicleList, this);
            rec_vehicles.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
            rec_vehicles.setAdapter(vehicleAdapter);

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
                final List<ProductModel> PList=filter(VehicleList,newText);
                vehicleAdapter.setFilterList(PList);
                return true;
            }
        });
        return true;
    }
    private List<ProductModel> filter(List<ProductModel> vehicleList,String newText)
    {
        final  List<ProductModel> PList=new ArrayList<>();
        for (ProductModel searchproduct : vehicleList)
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