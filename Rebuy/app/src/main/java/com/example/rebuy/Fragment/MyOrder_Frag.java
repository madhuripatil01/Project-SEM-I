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
import com.example.rebuy.DataModels.OrderModel;
import com.example.rebuy.DataModels.ProductModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.RebuyDatabaseClient;
import com.example.rebuy.Utility.Shared_Preference_Manager;

import java.util.ArrayList;
import java.util.List;

public class MyOrder_Frag extends Fragment {
    Context context;
    List<OrderModel> OrderList=new ArrayList<>();
    RecyclerView recViewMyOrders;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_orders_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recViewMyOrders=view.findViewById(R.id.recViewMyOrders);
        SharedPreferences sharedPreferences=context.getSharedPreferences("MyPref2",0);
        String Bname=sharedPreferences.getString("BuyerName","");
        OrderList= RebuyDatabaseClient.getRebuyInstance(context)
                .getRebuyDatabase()
                .orderDAO().selectOrderByBuyerId(Bname);
                //.selectOrderByBuyerId(Shared_Preference_Manager.getBuyer_ID(context));

        MyOrderAdapter myOrderAdapter = new MyOrderAdapter(OrderList,context);
        recViewMyOrders.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recViewMyOrders.setAdapter(myOrderAdapter);


    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
