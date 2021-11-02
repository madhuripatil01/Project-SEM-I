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

import com.example.rebuy.Adapter.BuyerListAdapter;
import com.example.rebuy.Adapter.SellerListAdapter;
import com.example.rebuy.DataModels.BuyerModel;
import com.example.rebuy.DataModels.SellerModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.RebuyDatabaseClient;

import java.util.List;

public class ShowBuyerFrg extends Fragment {
    private List<BuyerModel> BuyerList;
    Context context;
    RecyclerView buyerreclist;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.showbuyers,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buyerreclist=view.findViewById(R.id.buyerreclist);

        BuyerList= RebuyDatabaseClient.getRebuyInstance(context).getRebuyDatabase()
                .buyerDAO().getAllBuyers();

        BuyerListAdapter buyerListAdapter=new BuyerListAdapter(BuyerList,context);
       buyerreclist.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
       buyerreclist.setAdapter(buyerListAdapter);


    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}


