package com.example.rebuy.Utility;

import android.content.Context;



public class Shared_Preference_Manager {

    public static boolean setUser_ID(Context context,long User_Id)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit()
                .putLong(Shared_Preference_Key_Constant.USER_ID,User_Id).commit();
    }

    public static long getUser_ID(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getLong(Shared_Preference_Key_Constant.USER_ID,0);
    }

    public static String getUName(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getString(Shared_Preference_Key_Constant.UName,"");
    }
    public static boolean setUName(Context context,String MyApp_Id)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit()
                .putString(Shared_Preference_Key_Constant.UName,MyApp_Id).commit();

    }
    public static long getUPassword(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getInt(Shared_Preference_Key_Constant.UPassword,0);
    }
    public static boolean setUPassword(Context context,long MyApp_Id)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit()
                .putLong(Shared_Preference_Key_Constant.UPassword,MyApp_Id).commit();

    }


    public static boolean setSeller_ID(Context context,long Seller_Id)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit()
                .putLong(Shared_Preference_Key_Constant.Seller_ID,Seller_Id).commit();

    }


    public static long getSeller_ID(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getLong(Shared_Preference_Key_Constant.Seller_ID,0);
    }


    public static boolean setAppList_ID(Context context,long AppList_Id)
    {
        return My_Application.getInstance().getSharedPreferences(context).
                edit().putLong(Shared_Preference_Key_Constant.AppList_ID,AppList_Id).commit();
    }

    public static long getAppList_ID(Context context)
    {
        return  My_Application.getInstance().getSharedPreferences(context)
                .getLong(Shared_Preference_Key_Constant.AppList_ID,0);
    }
    public static boolean setBuyer_ID(Context context,long Buyer_Id)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit()
                .putLong(Shared_Preference_Key_Constant.Buyer_ID,Buyer_Id).commit();
    }
    public static  long getBuyer_ID(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getLong(Shared_Preference_Key_Constant.Buyer_ID,0);
    }
    public static boolean setUser_Name(Context context,String User_Name)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit().
        putString(Shared_Preference_Key_Constant.USER_NAME,User_Name).commit();
    }
    public static String getUser_Name(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getString(Shared_Preference_Key_Constant.USER_NAME,"");
    }
    public static boolean setUser_Type(Context context,String User_Type)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit().
                putString(Shared_Preference_Key_Constant.USER_TYPE,User_Type).commit();
    }

    public static String getEmail(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getString(Shared_Preference_Key_Constant.USER_EMAIL,"");
    }
    public static boolean setEmail(Context context,String User_Email)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit().
                putString(Shared_Preference_Key_Constant.USER_EMAIL,User_Email).commit();
    }
    public static String getUser_Mobile(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getString(Shared_Preference_Key_Constant.USER_MOB_NO,"");
    }
    public static boolean setUser_Mobile(Context context,String Mob_No)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit().
                putString(Shared_Preference_Key_Constant.USER_MOB_NO,Mob_No).commit();
    }
    public static boolean setSellerProfileSet(boolean sellerprofileset,Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit().
                putBoolean(Shared_Preference_Key_Constant.SellerProfileSet,sellerprofileset).commit();
    }

    public static boolean getSellerProfileSet(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getBoolean(Shared_Preference_Key_Constant.SellerProfileSet,false);
    }
    public static boolean setBuyerProfileSet(boolean buyerprofileset,Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context).edit().
                putBoolean(Shared_Preference_Key_Constant.BuyerProfileSet,buyerprofileset).commit();
    }

    public static boolean getBuyerProfileSet(Context context)
    {
        return My_Application.getInstance().getSharedPreferences(context)
                .getBoolean(Shared_Preference_Key_Constant.BuyerProfileSet,false);
    }



}
