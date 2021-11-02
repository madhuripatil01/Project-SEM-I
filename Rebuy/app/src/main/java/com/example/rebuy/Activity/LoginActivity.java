package com.example.rebuy.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.rebuy.DataModels.UserModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.RebuyDatabaseClient;
import com.example.rebuy.Utility.Shared_Preference_Manager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton btnlogin;

    EditText edtemail,edtpswd;
    TextView txtForgetPass;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

      btnlogin=findViewById(R.id.btnlogin);
      edtemail=findViewById(R.id.edtmob);
      edtpswd=findViewById(R.id.edtpswd);
      txtForgetPass=findViewById(R.id.txtForgetPass);
      btnlogin.setOnClickListener(this);

      txtForgetPass.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v)
          {
              Intent intent = new Intent(LoginActivity.this, Forget_Pass_Act.class);
              startActivity(intent);

          }
      });
    }

    @Override
    public void onClick(View v) {
        try {


            if (edtemail.getText().toString().equals("admin") && edtpswd.getText().toString().equals("admin")) {
                Intent intent = new Intent(LoginActivity.this, Appbar_Activity.class);
                startActivity(intent);
            } else {

                UserModel userModel = RebuyDatabaseClient.getRebuyInstance(getApplicationContext()).getRebuyDatabase()
                        .userDAO().userLogin(edtemail.getText().toString()
                                , edtpswd.getText().toString());


                if (userModel.getUsertype().equals("Seller")) {
                    if(userModel.getUserEmail().equals(edtemail.getText().toString())) {
                        SharedPreferences sharedPreferences = getSharedPreferences("MyPref", 0);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("SellerName", userModel.getUserName());
                        editor.commit();
                        Intent intent = new Intent(LoginActivity.this, Seller_BtmNav_Act.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(this, "Invalid  Email Address!", Toast.LENGTH_SHORT).show();
                    }


                } else if (userModel.getUsertype().equals("Buyer")) {
                    if(userModel.getUserPasswd().equals(edtpswd.getText().toString())) {
                        SharedPreferences sharedPreferences = getSharedPreferences("MyPref2", 0);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("BuyerName",userModel.getUserName());
                        editor.commit();
                        Intent intent = new Intent(LoginActivity.this, Drawer_Activity.class);
                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(this, "Invalid Password!", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        }
       catch(Exception e)
            {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }



        }


    }

