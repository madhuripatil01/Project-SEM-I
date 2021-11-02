package com.example.rebuy.Utility;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.util.regex.Pattern;

public class UtilityMethods {

  public static byte[] imgConvertFromBitmapToByteArray(Bitmap bitmap)
  {
      ByteArrayOutputStream blob=new ByteArrayOutputStream();
      bitmap.compress(Bitmap.CompressFormat.PNG,0,blob);
      return blob.toByteArray();
  }
  public static Bitmap imgConvertFromByteArrayToBitmap(byte[] image)
  {
      return BitmapFactory.decodeByteArray(image,0,image.length);
  }
  public static boolean isValidMobile(String mobile)
  {
      return Pattern.compile("[6-9][0-9]{9}").matcher(mobile).matches();
  }

}
