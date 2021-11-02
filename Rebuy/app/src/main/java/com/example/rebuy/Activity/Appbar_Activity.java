package com.example.rebuy.Activity;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.ScrollingTabContainerView;


import com.example.rebuy.Fragment.ShowBuyerFrg;
import com.example.rebuy.Fragment.ShowSellerFrg;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import com.example.rebuy.R;


public class Appbar_Activity extends AppCompatActivity {

        Toolbar toolbar;
        TabLayout tabLayout;
        ViewPager viewPager;
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setSupportActionBar(toolbar);
            setContentView(R.layout.showappuserslayout);
            toolbar=findViewById(R.id.toolbar);
            tabLayout=findViewById(R.id.tablayout);
            viewPager=findViewById(R.id.viewpager);
            ViewPageAdapter viewPageAdapter=new ViewPageAdapter(getSupportFragmentManager());

            viewPageAdapter.addFragmentAndTitle(new ShowBuyerFrg(),"Buyers");
            viewPageAdapter.addFragmentAndTitle(new ShowSellerFrg(),"Seller");

            viewPager.setAdapter(viewPageAdapter);
            tabLayout.setupWithViewPager(viewPager);
        }

        private class ViewPageAdapter extends FragmentPagerAdapter
        {
            private  final ArrayList<Fragment> fragmentList=new ArrayList<>();
            private final ArrayList<String> tabtitles=new ArrayList<>();

            public ViewPageAdapter(@NonNull FragmentManager fm) {
                super(fm);
            }

            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return tabtitles.get(position);
            }
            public void addFragmentAndTitle(Fragment fragment,String title)
            {
                fragmentList.add(fragment);
                tabtitles.add(title);
            }
        }
    }


