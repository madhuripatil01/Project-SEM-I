package com.example.rebuy.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebuy.Adapter.MyOrderAdapter;
import com.example.rebuy.Adapter.SellerHomeAdapter;
import com.example.rebuy.DataModels.BuyerModel;
import com.example.rebuy.DataModels.InquiriesModel;
import com.example.rebuy.DataModels.UserModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.RebuyDatabaseClient;
import com.example.rebuy.Utility.Shared_Preference_Manager;

import java.util.ArrayList;
import java.util.List;

public class Seller_Home_Frag extends Fragment {
    Context context;
    RecyclerView rec_Seller_Home;
     List<InquiriesModel> ProdViewList = new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.seller_home_frg_layout,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rec_Seller_Home=view.findViewById(R.id.rec_Seller_Home);

//        //List<String> UIdList=new ArrayList<String>();
//        SharedPreferences sharedPreferences=context.getSharedPreferences("MyPref",0);
//        long uID=sharedPreferences.getLong("UserId",0);
//       Toast.makeText(context,String.valueOf(uID), Toast.LENGTH_LONG).show();
        SharedPreferences sharedPreferences=context.getSharedPreferences("MyPref3",0);
        String pname=sharedPreferences.getString("ProdName","");
     ProdViewList = RebuyDatabaseClient.getRebuyInstance(context)
             .getRebuyDatabase().inquiriesDAO().selectInqByProdName(pname);
        SellerHomeAdapter sellerHomeAdapter = new SellerHomeAdapter(context,ProdViewList);
        rec_Seller_Home.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        rec_Seller_Home.setAdapter(sellerHomeAdapter);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}


