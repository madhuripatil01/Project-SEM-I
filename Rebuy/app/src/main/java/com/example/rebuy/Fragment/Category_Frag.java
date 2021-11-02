package com.example.rebuy.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebuy.Activity.BookListActivity;
import com.example.rebuy.Activity.ElectronicsListActivity;
import com.example.rebuy.Activity.FurnitureListActivity;
import com.example.rebuy.Activity.VehiclesListActivity;
import com.example.rebuy.R;

public class Category_Frag extends Fragment implements View.OnClickListener {
    Context context;
    RecyclerView recview;
    CardView cardViewFurniture,cardViewVehicle,cardViewElectronic,cardViewBook;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.catergory_lay,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cardViewFurniture=view.findViewById(R.id.cardviewFurniture);
        cardViewVehicle=view.findViewById(R.id.cardviewVehicle);
        cardViewElectronic=view.findViewById(R.id.cardviewElectronic);
        cardViewBook=view.findViewById(R.id.cardviewBook);
       cardViewFurniture.setOnClickListener(this);
        cardViewVehicle.setOnClickListener(this);
        cardViewElectronic.setOnClickListener(this);
        cardViewBook.setOnClickListener(this);



    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.cardviewFurniture)
        {
            Intent intent = new Intent(context, FurnitureListActivity.class);
            intent.putExtra("catogoryFurniture","Furniture");
            startActivity(intent);
        }
        else if (v.getId()==R.id.cardviewVehicle)
        {
            Intent intent = new Intent(context, VehiclesListActivity.class);
            intent.putExtra("catogoryVehicle","Vehicle");
            startActivity(intent);

        }
        else if(v.getId()==R.id.cardviewElectronic)
        {
            Intent intent = new Intent(context, ElectronicsListActivity.class);
            intent.putExtra("catogoryElectronic","Electronic");
            startActivity(intent);
        }
        else if(v.getId()==R.id.cardviewBook)
        {
            Intent intent = new Intent(context, BookListActivity.class);
            intent.putExtra("catogoryBook","Book");
            startActivity(intent);
        }

    }
}


