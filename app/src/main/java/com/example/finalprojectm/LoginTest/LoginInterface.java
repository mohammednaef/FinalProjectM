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


    @Override
    public void isValidEmail(CharSequence email) {

    }

    @Override
    public boolean isValidPassword(CharSequence password) {
      return false;

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
