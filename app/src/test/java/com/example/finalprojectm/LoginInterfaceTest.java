package com.example.finalprojectm;

import com.example.finalprojectm.LoginTest.LoginInterface;
import com.example.finalprojectm.LoginTest.LoginValidatorInterface;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LoginInterfaceTest extends TestCase {

    LoginInterface loginInterface;
    @Mock
    LoginValidatorInterface loginValidatorInterface;

    @Before
    public void setup() throws Exception{
        loginInterface = new LoginInterface(loginValidatorInterface);

    }

    @Test
    public void TestIsValidEmail(){
        CharSequence email = "yousef@gmail.com";

        Mockito.verify(loginValidatorInterface).isValidEmail(email);


    }

    @Test
    public void TestIsValidPassword(){
        CharSequence password = "669966Y@y00!";
        Mockito.verify(loginValidatorInterface).isValidPassword(password);


    }

}
