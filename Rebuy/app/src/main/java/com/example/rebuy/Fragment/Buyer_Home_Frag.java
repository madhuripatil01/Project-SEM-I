package com.example.rebuy.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebuy.Adapter.ItemListAdapter;
import com.example.rebuy.Adapter.MyOrderAdapter;
import com.example.rebuy.DataModels.OrderModel;
import com.example.rebuy.DataModels.ProductModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.RebuyDatabaseClient;

import java.util.ArrayList;
import java.util.List;

public class Buyer_Home_Frag extends Fragment {

    Context context;
    RecyclerView recViewBuyerHome;
    List<ProductModel> ProdList=new ArrayList<>();
    ItemListAdapter itemListAdapter;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.buyer_home_layout,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        recViewBuyerHome=view.findViewById(R.id.recViewBuyerHome);
        ProdList= RebuyDatabaseClient.getRebuyInstance(context)
                .getRebuyDatabase()
                .productDAO().getAllProducts();
        itemListAdapter = new ItemListAdapter(context,ProdList);
        recViewBuyerHome.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recViewBuyerHome.setAdapter(itemListAdapter);

    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        getActivity().getMenuInflater().inflate(R.menu.search_menu,menu);

        MenuItem menuItem=menu.findItem(R.id.action_search);
        SearchView searchView= (SearchView) menuItem.getActionView();

        searchView.setQueryHint("Search All Products");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                final List<ProductModel> PList=filter(ProdList,newText);
                itemListAdapter.setFilterList(PList);
                return true;
            }
        });
    }

    private List<ProductModel> filter(List<ProductModel> ProdList, String newText)
    {
        final  List<ProductModel> PList=new ArrayList<>();
        for (ProductModel productModel : ProdList)
        {
            final String text=productModel.getProdName().toLowerCase();
            if (text.contains(newText))
            {
                PList.add(productModel);
            }
        }
        return PList;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
