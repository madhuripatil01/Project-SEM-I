package com.example.rebuy.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebuy.Adapter.SellerListAdapter;
import com.example.rebuy.DataModels.SellerModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.RebuyDatabaseClient;

import java.util.List;

public class ShowSellerFrg extends Fragment
{
    private List<SellerModel> SellerList;
    Context context;
    RecyclerView Sellerrecview;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.showsellers,container,false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Sellerrecview=view.findViewById(R.id.sellerreclist);

        SellerList= RebuyDatabaseClient.getRebuyInstance(context).getRebuyDatabase()
                .sellerDAO().getAllSellers();

        SellerListAdapter sellerListAdapter=new SellerListAdapter(SellerList,context);
        Sellerrecview.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        Sellerrecview.setAdapter(sellerListAdapter);


    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}


