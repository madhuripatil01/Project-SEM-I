package com.example.rebuy.Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MobileValidator {
    private Pattern pattern;
    private Matcher matcher;




    public boolean mobvalidate(String phone) {
        boolean check = false;
        if (phone.length() < 12 && phone.length() > 12) {
            check = false;
        } else {
            check = true;
        }
        return check;
    }
}


