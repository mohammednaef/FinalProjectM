package com.example.finalprojectm.LoginTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidation {

    private final String PATTERN = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%_.*-]).{8,20}$";

    public boolean isValidPassword(String password) {
        if(password == null){
            return false;
        }else {
            Pattern pattern = Pattern.compile(this.PATTERN);
            Matcher matcher = pattern.matcher(password);
            return matcher.matches();
        }

    }
}
