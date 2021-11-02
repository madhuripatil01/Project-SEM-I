package com.example.rebuy.Activity;

import android.Manifest;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

import com.example.rebuy.DataModels.UserModel;
import com.example.rebuy.R;
import com.example.rebuy.Utility.EmailValidator;
import com.example.rebuy.Utility.MobileValidator;
import com.example.rebuy.Utility.RebuyDatabaseClient;
import com.example.rebuy.Utility.Shared_Preference_Manager;
import com.example.rebuy.Utility.UtilityMethods;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton btnreg;
    TextView txtskip;
    EditText edtname,edtmobno,edtemail,edtpassword,edtcompassword;
    RadioGroup rbgroup;
    RadioButton rbnSeller,rbnbuyer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);

        btnreg=findViewById(R.id.btnreg);
        txtskip=findViewById(R.id.txtskip);
        edtemail=findViewById(R.id.edtemail);
        edtmobno=findViewById(R.id.edtmobno);
        edtname=findViewById(R.id.edtname);
        edtpassword=findViewById(R.id.edtpassword);
        rbgroup=findViewById(R.id.rbgroup);
        rbnbuyer=findViewById(R.id.rbnbuyer);
        rbnSeller=findViewById(R.id.rbnseller);
        edtcompassword=findViewById(R.id.edtcompassword);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 1);


        btnreg.setOnClickListener(this);

        txtskip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId()==R.id.txtskip)
                {
                    Intent i=new Intent(RegistrationActivity.this,LoginActivity.class);
                    startActivity(i);

                }

            }
        });

    }

    @Override
    public void onClick(View v) {

        EmailValidator emailValidator=new EmailValidator();
         MobileValidator mobileValidator=new MobileValidator();



        if (!TextUtils.isEmpty(edtemail.getText().toString())
                && !TextUtils.isEmpty(edtmobno.getText().toString())
                && !TextUtils.isEmpty(edtpassword.getText().toString()) &&
                !TextUtils.isEmpty(edtname.getText().toString()))
        {
            if (emailValidator.validate(edtemail.getText().toString())==true)

            {
                if (UtilityMethods.isValidMobile(edtmobno.getText().toString())) {
                    if (edtpassword.getText().toString().equals(edtcompassword.getText().toString())) {
                        UserModel userModel = new UserModel();

                        userModel.setUserMobNo(edtmobno.getText().toString());
                        userModel.setUserEmail(edtemail.getText().toString());
                        userModel.setUserPasswd(edtpassword.getText().toString());
                        userModel.setUsertype(getRadioButtonValue());
                        userModel.setUserName(edtname.getText().toString());

                        long uId = RebuyDatabaseClient.getRebuyInstance(getApplicationContext()).getRebuyDatabase().
                                userDAO().insertUserModel(userModel);

                        Toast.makeText(this, "Registration Successfull", Toast.LENGTH_SHORT).show();

                        String no = edtmobno.getText().toString();
                        String msg = "Registration Successful";

                        Intent intent1 = new Intent(getApplicationContext(),LoginActivity.class);
                        PendingIntent pi = PendingIntent.getActivity(getApplicationContext(), 0, intent1, 0);

                        SmsManager sms = SmsManager.getDefault();
                        sms.sendTextMessage(no, null, msg, pi, null);

                        Shared_Preference_Manager.setUser_ID(RegistrationActivity.this, uId);
                        Shared_Preference_Manager.setUser_Type(RegistrationActivity.this, getRadioButtonValue());
                        Shared_Preference_Manager.setUser_Mobile(RegistrationActivity.this,
                                edtmobno.getText().toString());
                        Shared_Preference_Manager.setEmail(RegistrationActivity.this, edtemail.getText().toString());
                        Shared_Preference_Manager.setUName(RegistrationActivity.this, edtname.getText().toString());


                        if (getRadioButtonValue().equals("Seller")) {
                            Shared_Preference_Manager.setBuyerProfileSet(false, RegistrationActivity.this);
                        } else {
                            Shared_Preference_Manager.setSellerProfileSet(false, RegistrationActivity.this);
                        }


                        Intent intent = new Intent(this, LoginActivity.class);
                        intent.putExtra("utype", getRadioButtonValue());
                        startActivity(intent);

                    }
                    else
                    {
                        Toast.makeText(this, "Enter Same Password!", Toast.LENGTH_SHORT).show();
                    }
                }

                else {
                    Toast.makeText(this,"Enter Valid Mobile Number",Toast.LENGTH_SHORT).show();
                }


            }

            else
            {
                Toast.makeText(this,"Please enter valid Email",Toast.LENGTH_SHORT).show();
            }

        }
        else
        {
            Toast.makeText(RegistrationActivity.this,"Enter All the fields",
                    Toast.LENGTH_SHORT).show();
        }

    }


    private String getRadioButtonValue()
    {
        int chkId=rbgroup.getCheckedRadioButtonId();
        if (chkId==R.id.rbnseller)
        {
            return "Seller";
        }
        else if(chkId==R.id.rbnbuyer)
        {
            return "Buyer";
        }
        else
        {
            return null;
        }

    }
}

