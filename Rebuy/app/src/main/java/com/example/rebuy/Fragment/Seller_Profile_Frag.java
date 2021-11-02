package com.example.rebuy.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebuy.Activity.RegistrationActivity;
import com.example.rebuy.DataModels.ProductModel;
import com.example.rebuy.DataModels.SellerModel;
import com.example.rebuy.DataModels.UserModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.RebuyDatabaseClient;
import com.example.rebuy.Utility.Shared_Preference_Manager;
import com.example.rebuy.Utility.UtilityMethods;

import static android.app.Activity.RESULT_OK;

public class Seller_Profile_Frag extends Fragment implements View.OnClickListener {

    Context context;

    ImageView profileimg;
    EditText edtsname,edtsemail,edtsadress,edtsmobno;
    BitmapFactory.Options options;
    Bitmap bitmapProd;
    Button btnsave,btnlogout;
    private long sId;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.seller_profile,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         profileimg = view.findViewById(R.id.profile_image);
         edtsname=view.findViewById(R.id.edtsname);
         edtsemail=view.findViewById(R.id.edtsemail);
         edtsmobno=view.findViewById(R.id.edtsmobno);
         edtsadress=view.findViewById(R.id.edtsaddress);
         btnsave=view.findViewById(R.id.btnsave);
        btnlogout=view.findViewById(R.id.btnlogout);
        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.
                CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE},20);

        UserModel userModel = RebuyDatabaseClient.getRebuyInstance(context)
                .getRebuyDatabase().userDAO()
                .selectUserById(Shared_Preference_Manager.getUser_ID(context));

            edtsname.setText(userModel.getUserName());
            edtsemail.setText(userModel.getUserEmail());
            edtsmobno.setText(userModel.getUserMobNo());

        profileimg.setOnClickListener(this);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SellerModel sellerModel = new SellerModel();
                    sellerModel.setSellerName(edtsname.getText().toString());
                    sellerModel.setSellerEmail(edtsemail.getText().toString());
                    sellerModel.setSellerContactNo(edtsmobno.getText().toString());
                    sellerModel.setSellerAddress(edtsadress.getText().toString());
                    sellerModel.setImgSeller(UtilityMethods.imgConvertFromBitmapToByteArray(bitmapProd));


                    sId = RebuyDatabaseClient.getRebuyInstance(getActivity().getApplicationContext())
                            .getRebuyDatabase().sellerDAO().insertSellerModel(sellerModel);
                    Toast.makeText(context, "Seller Added Successfully", Toast.LENGTH_SHORT).show();

                }
                catch(Exception e)
                {
                    Toast.makeText(context, "Please add Profile Image!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnlogout.setOnClickListener(this);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.profile_image)
        {
            Intent PickPic=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(PickPic,1);
        }
        if(v.getId()==R.id.btnlogout)
        {
            Intent i=new Intent(context, RegistrationActivity.class);
             startActivity(i);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null && requestCode == 1) {
            Uri SelectedImage = data.getData();
            String[] FilePathColumn = {MediaStore.Images.Media.DATA};
            if (SelectedImage != null) {
                Cursor cursor = context.getContentResolver().query(SelectedImage, FilePathColumn, null, null, null);
                if (cursor != null) {
                    cursor.moveToFirst();

                    int ColumnIndex = cursor.getColumnIndex(FilePathColumn[0]);
                    String PicturePath = cursor.getString(ColumnIndex);
                    options = new BitmapFactory.Options();
                    options.inSampleSize = 2;
                    bitmapProd = BitmapFactory.decodeFile(PicturePath, options);
                    profileimg.setImageBitmap(bitmapProd);
                    cursor.close();
                }
            }
        }
    }
}
