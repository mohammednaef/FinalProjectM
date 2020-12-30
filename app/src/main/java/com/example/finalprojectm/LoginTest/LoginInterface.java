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

    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    private boolean mIsValid = false;

    public boolean isValid() {
        return mIsValid;
    }

    @Override
    public boolean isValidEmail(CharSequence email) {
        return  email != null && EMAIL_PATTERN.matcher(email).matches();

    }

    @Override
    public boolean isValidPassword(CharSequence password) {

        if(password == null){
            return false;
        }else {
            Pattern pattern = Pattern.compile(this.PATTERN);
            Matcher matcher = pattern.matcher(password);
            return matcher.matches();
        }

    }

    @Override
    final public void afterTextChanged(Editable editableText) {
        mIsValid = isValidEmail(editableText);
    }

    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) {/*No-op*/}

    @Override
    final public void onTextChanged(CharSequence s, int start, int before, int count) {/*No-op*/}
}

