package com.example.rebuy.Activity;

import android.os.Bundle;


import com.example.rebuy.Fragment.Buyer_Home_Frag;
import com.example.rebuy.Fragment.Buyer_Profile_Frag;
import com.example.rebuy.Fragment.Category_Frag;
import com.example.rebuy.Fragment.MyOrder_Frag;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;

import com.example.rebuy.R;

import android.view.Menu;

public class Drawer_Activity extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawer;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer =(DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView =(NavigationView) findViewById(R.id.nav_view);


        setUpNavigationView();


    }


    private void setUpNavigationView() {
              navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_home:
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.nav_host_fragment, new Buyer_Home_Frag());
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle("Home");
                        break;
                    case R.id.nav_category:
                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                        fragmentTransaction1.replace(R.id.nav_host_fragment, new Category_Frag());
                        fragmentTransaction1.commit();
                        getSupportActionBar().setTitle("Categories");
                        break;
                    case R.id.nav_myorder:
                        FragmentManager fragmentManager2 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                        fragmentTransaction2.replace(R.id.nav_host_fragment, new MyOrder_Frag());
                        fragmentTransaction2.commit();
                        getSupportActionBar().setTitle("My Orders");
                        break;
                    case R.id.nav_profile:
                        FragmentManager fragmentManager3 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                        fragmentTransaction3.replace(R.id.nav_host_fragment, new Buyer_Profile_Frag());
                        fragmentTransaction3.commit();
                        getSupportActionBar().setTitle("Profile");
                        break;
                        default:
                }
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);
                drawer.closeDrawers();
                return true;
            }

        });
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(Drawer_Activity.this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }


        };
        drawer.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

     /*  @Override
        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.
           getMenuInflater().inflate(R.menu.activity_drawer__drawer,menu);
            return true;
        }
        */



    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawers();
            return;
        }
        super.onBackPressed();
    }

}
