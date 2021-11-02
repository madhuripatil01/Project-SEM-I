package com.example.rebuy.Activity;

import android.Manifest;
import android.app.DatePickerDialog;
import java.util.Calendar;
import android.app.Dialog;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rebuy.DataModels.OrderModel;
import com.example.rebuy.DataModels.ProductModel;
import com.example.rebuy.Fragment.Buyer_Home_Frag;
import com.example.rebuy.Fragment.MyOrder_Frag;
import com.example.rebuy.R;
import com.example.rebuy.Utility.RebuyDatabaseClient;
import com.example.rebuy.Utility.Shared_Preference_Manager;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;


public class Proceed_Activity extends AppCompatActivity implements View.OnClickListener {
    EditText edtProBuyerName,edtProBuyerMob,edtProBuyerAddress;
    TextView txtProcBuyerdate,txtProctotalBuyerprice,txtConfirmMsg;
    Button btn_proceed;

    String str1,str2,str3;
    private int mYear,mMonth,mDay;
    Calendar calendar;
    String strDate;
    Button btnCancelBtn,btnConfirmBtn;
    private long OrdId;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proceed_layout);
        calendar=Calendar.getInstance();
        edtProBuyerName=findViewById(R.id.edtProBuyerName);
        edtProBuyerMob=findViewById(R.id.edtProcBuyermob);
        edtProBuyerAddress=findViewById(R.id.edtProcBuyerAddress);
        txtProctotalBuyerprice=findViewById(R.id.txtProctotalBuyerprice);
        txtProcBuyerdate=findViewById(R.id.txtProcBuyerdate);
        btn_proceed=findViewById(R.id.btn_proceed);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);


        str1=edtProBuyerName.getText().toString();
        str2=edtProBuyerAddress.getText().toString();
        str3=edtProBuyerMob.getText().toString();

        btn_proceed.setOnClickListener(this);
        txtProcBuyerdate.setOnClickListener(this);
        final ProductModel productModel = (ProductModel) getIntent().getSerializableExtra("prodOrderInfo");
         try {

             txtProctotalBuyerprice.setText(productModel.getProdPrice());
         }
         catch(Exception e)
         {}

        btn_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    View view= LayoutInflater.from(Proceed_Activity.this).inflate(R.layout.confirmationdialoguelayout,null);
                    androidx.appcompat.app.AlertDialog.Builder builder=new androidx.appcompat.app.AlertDialog.Builder(Proceed_Activity.this);
                    builder.setView(view);
                    builder.create().show();

                    btnCancelBtn=view.findViewById(R.id.btnCancel);
                    btnConfirmBtn=view.findViewById(R.id.btnConfirm);
                    txtConfirmMsg=view.findViewById(R.id.txtConfirmMsg);

                    btnConfirmBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            OrderModel orderModel=new OrderModel();

                            orderModel.setOrdProName(productModel.getProdName());
                            orderModel.setOrdProdCategory(productModel.getProdCategory());
                            orderModel.setOrdImgProd(productModel.getImgProd());
                            orderModel.setSellerName(productModel.getSellerName());
                            orderModel.setOrdProdPrice(productModel.getProdPrice());
                            orderModel.setProdId(productModel.getProdId());
                            orderModel.setBuyerId(Shared_Preference_Manager.getUser_ID(Proceed_Activity.this));
                            orderModel.setOrdBuyerName(edtProBuyerName.getText().toString());
                            orderModel.setOrdBuyerMobNo(edtProBuyerMob.getText().toString());
                            orderModel.setOrdBuyerAddress(edtProBuyerAddress.getText().toString());
                            orderModel.setOrdDate(txtProcBuyerdate.getText().toString());
                            orderModel.setSold(true);
                           OrdId= RebuyDatabaseClient.getRebuyInstance(getApplication().getApplicationContext())
                                    .getRebuyDatabase().orderDAO().insertOrderModel(orderModel);
                            RebuyDatabaseClient.getRebuyInstance(getApplication().getApplicationContext())
                                    .getRebuyDatabase()
                                    .productDAO()
                                    .deleteProductModel(orderModel.getOrdProName());
                            //Toast.makeText(Proceed_Activity.this, orderModel.getBuyerId(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(Proceed_Activity.this, "Order Successfull", Toast.LENGTH_SHORT).show();

                            String no = edtProBuyerMob.getText().toString();
                            String msg = "Order Successful";

                            Intent intent = new Intent(getApplicationContext(), Drawer_Activity.class);
                            PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

                            SmsManager sms = SmsManager.getDefault();
                            sms.sendTextMessage(no, null, msg, pi, null);


                        }
                    });
                    btnCancelBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(Proceed_Activity.this,Drawer_Activity.class);
                            startActivity(intent);
                        }
                    });
                    AlertDialog dialogbox1=builder.create();
                    dialogbox1.dismiss();
                }

        });
    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.txtProcBuyerdate)
        {
            mYear=calendar.get(Calendar.YEAR);
            mMonth=calendar.get(Calendar.MONTH);
            mDay=calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog=new DatePickerDialog(this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            strDate=dayOfMonth+"-"+(month+1)+"-"+year;
                            txtProcBuyerdate.setText(strDate);
                        }
                    },mYear,mMonth,mDay);
            datePickerDialog.show();
        }

    }
}
