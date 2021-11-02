package com.example.rebuy.Utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            +"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    //private static final String PHONE_PATTERN="^[+][0-9]{10,13}$";

    public EmailValidator() {
        pattern=Pattern.compile(EMAIL_PATTERN);

    }
    public boolean validate(final String hex)
    {
        matcher=pattern.matcher(hex);
        return matcher.matches();
    }

    /*public boolean mobvalidate(final String hex1)
    {
        matcher=pattern.matcher(hex1);
        return matcher.matches();
    }*/

}
