package com.example.rebuy.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.rebuy.DataModels.BuyerModel;
import com.example.rebuy.DataModels.InquiriesModel;
import com.example.rebuy.DataModels.ProductModel;
import com.example.rebuy.DataModels.UserModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.RebuyDatabaseClient;
import com.example.rebuy.Utility.Shared_Preference_Manager;
import com.example.rebuy.Utility.UtilityMethods;

public class BuyProduct extends AppCompatActivity
{
    ImageView imgBuyProdInfo;
    TextView txtBuyproName,txtBuyProdPrize,txtBuyProdDetails;
    Button btn_buy,BtnInquiries;
    private long InqId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.buy_layout);
        txtBuyproName=findViewById(R.id.txtBuyproName);
        txtBuyProdPrize=findViewById(R.id.txtBuyProdPrize);
        txtBuyProdDetails=findViewById(R.id.txtBuyProdDetails);
        imgBuyProdInfo=findViewById(R.id.imgBuyProdInfo);
        btn_buy=findViewById(R.id.btn_buy);
        BtnInquiries=findViewById(R.id.BtnInquiries);
        final ProductModel productModel= (ProductModel) getIntent().getSerializableExtra("ProdInfo");

        imgBuyProdInfo.setImageBitmap(UtilityMethods.imgConvertFromByteArrayToBitmap(productModel.getImgProd()));
        txtBuyproName.setText(productModel.getProdName());
        txtBuyProdPrize.setText(productModel.getProdPrice());
        txtBuyProdDetails.setText(productModel.getProdDetails());
        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyProduct.this,Proceed_Activity.class);
                intent.putExtra("prodOrderInfo",productModel);
                startActivity(intent);

            }
        });
        BtnInquiries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //Toast.makeText(BuyProduct.this, Math.toIntExact(Shared_Preference_Manager.getBuyer_ID(BuyProduct.this)), Toast.LENGTH_SHORT).show();

                    BuyerModel buyerModel = RebuyDatabaseClient.getRebuyInstance(BuyProduct.this)
                            .getRebuyDatabase().buyerDAO()
                            .SelectBuyerById(Shared_Preference_Manager.getBuyer_ID(BuyProduct.this));
                    InquiriesModel inquiriesModel = new InquiriesModel();
                    inquiriesModel.setCustName(buyerModel.getBuyerName());
                    inquiriesModel.setCustId(buyerModel.getBuyerId());
                    inquiriesModel.setCustEmail(buyerModel.getBuyerEmail());
                    inquiriesModel.setCustMobNo(buyerModel.getBuyerContactNo());
                    inquiriesModel.setImgCust(buyerModel.getImgBuyer());
                    inquiriesModel.setInqProdName(txtBuyproName.getText().toString());
                    Toast.makeText(BuyProduct.this,buyerModel.getBuyerName(), Toast.LENGTH_SHORT).show();
                    InqId = RebuyDatabaseClient.getRebuyInstance(getApplication().getApplicationContext())
                            .getRebuyDatabase().inquiriesDAO().insertInquiriesModel(inquiriesModel);
                    Toast.makeText(BuyProduct.this, "Inquiry for product Successfully", Toast.LENGTH_SHORT).show();
                }
                catch(Exception e)
                {
                    Toast.makeText(BuyProduct.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
