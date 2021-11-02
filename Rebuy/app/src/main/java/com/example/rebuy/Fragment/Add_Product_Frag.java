package com.example.rebuy.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
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
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rebuy.DataModels.ProductModel;
import com.example.rebuy.DataModels.UserModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.RebuyDatabaseClient;
import com.example.rebuy.Utility.Shared_Preference_Manager;
import com.example.rebuy.Utility.UtilityMethods;

import static android.app.Activity.RESULT_OK;

public class Add_Product_Frag extends Fragment implements View.OnClickListener {
    Context context;
    RecyclerView recview;
    String[] listItem;
    EditText edtProdName,edtProdPrize;
    TextView txtSelectCategory,txtSelectImage;
    ImageView ImgAddProd;
    Button BtnProdAdd;
    BitmapFactory.Options options;
    Bitmap bitmapProd;
    public static final int CAMERA_REQUEST=20;
    private long PId;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_prod_layout,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        edtProdName=view.findViewById(R.id.edtProdName);
        edtProdPrize=view.findViewById(R.id.edtProdPrize);
        txtSelectCategory=view.findViewById(R.id.txtSelectCategory);
        txtSelectImage=view.findViewById(R.id.txtSelectImage);
        BtnProdAdd=view.findViewById(R.id.BtnProdAdd);
        ImgAddProd=view.findViewById(R.id.ImgAddProd);
        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE},20);
        listItem=getResources().getStringArray(R.array.item_Capacity);

        txtSelectCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setTitle("Choose Product Category");
                builder.setSingleChoiceItems(listItem, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        txtSelectCategory.setText(listItem[i]);
                        dialog.dismiss();
                    }
                });
                AlertDialog dialogbox1=builder.create();
                dialogbox1.show();

            }
        });
        BtnProdAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModel userModel=RebuyDatabaseClient.getRebuyInstance(context)
                        .getRebuyDatabase().userDAO().selectUserById(Shared_Preference_Manager.getUser_ID(context));
                ProductModel productModel=new ProductModel();
                productModel.setProdName(edtProdName.getText().toString());
                productModel.setProdCategory(txtSelectCategory.getText().toString());
                productModel.setProdPrice(edtProdPrize.getText().toString());
                productModel.setImgProd(UtilityMethods.imgConvertFromBitmapToByteArray(bitmapProd));
                productModel.setSellerName(userModel.getUserName());
                PId=RebuyDatabaseClient.getRebuyInstance(getActivity().getApplicationContext())
                        .getRebuyDatabase().productDAO().insertProductModel(productModel);
                Toast.makeText(context, "Product Added Successfully", Toast.LENGTH_SHORT).show();
            }
        });
        ImgAddProd.setOnClickListener(this);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View v)
    {
        if (v.getId()==R.id.ImgAddProd)
        {
            Intent PickPic=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(PickPic,1);
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
                    ImgAddProd.setImageBitmap(bitmapProd);
                    cursor.close();
                }
            }
        }
    }
}


