package com.example.finalprojectm.LoginTest;

import android.text.Editable;
import android.text.TextWatcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginInterface implements TextWatcher, LoginValidatorInterface{
private LoginValidatorInterface view;
public LoginInterface(LoginValidatorInterface loginValidatorInterface){
    this.view = loginValidatorInterface;
}
    private final String PATTERN = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%_.*-]).{8,20}$";


    @Override
    public boolean isValidEmail(CharSequence email) {
        return false;

    }

    @Override
    public boolean isValidPassword(CharSequence password) {

        if(password == null){
            return false;
        }
        Pattern pattern = Pattern.compile(this.PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
