package com.example.finalprojectm;

import com.example.finalprojectm.LoginTest.EmailValidation;
import com.example.finalprojectm.LoginTest.LoginInterface;
import com.example.finalprojectm.LoginTest.LoginValidatorInterface;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LoginInterfaceTest extends TestCase {

    LoginInterface loginInterface;
    EmailValidation email;
    @Mock
    LoginValidatorInterface loginValidatorInterface;

    @Before
    public void setup() {
        loginInterface = new LoginInterface(loginValidatorInterface);
        email = new EmailValidation();

    }

    @Test
    public void TestIsValidEmail(){
        CharSequence email = "yousef@gmail.com";
        loginValidatorInterface.isValidEmail(email);
         Mockito.verify(loginValidatorInterface).isValidEmail(email);

    }

    @Test
    public void TestIsValidPassword(){
        CharSequence password = "123321@#Ty" ;
        loginValidatorInterface.isValidPassword(password);
        Mockito.verify(loginValidatorInterface).isValidPassword(password);


    }

    @Test
    public void test2(){
        assertFalse(email.isValidEmail("@yousef.com"));
        System.out.println("Emailtest2 success");
    }

    @Test
    public void test3(){
        assertFalse(email.isValidEmail(""));
        System.out.println("Emailtest3 success");
    }
}
