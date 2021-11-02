package com.example.rebuy.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.rebuy.Fragment.Add_Product_Frag;
import com.example.rebuy.Fragment.Seller_Home_Frag;
import com.example.rebuy.Fragment.Seller_Profile_Frag;
import com.example.rebuy.Fragment.Status_Frag;
import com.example.rebuy.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class Seller_BtmNav_Act extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener
{
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.botton_nav_layout);

        bottomNavigationView=findViewById(R.id.bottomnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if(menuItem.getItemId()==R.id.home)
        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.framelay,new Seller_Home_Frag());
            fragmentTransaction.commit();
        }
        if(menuItem.getItemId()==R.id.add_product)
        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.framelay,new Add_Product_Frag());
            fragmentTransaction.commit();
        }
        if(menuItem.getItemId()==R.id.status)
        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.framelay,new Status_Frag());
            fragmentTransaction.commit();
        }
        if(menuItem.getItemId()==R.id.profile)
        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.framelay, new Seller_Profile_Frag());
            fragmentTransaction.commit();
        }

        return true;
    }
}


