package com.example.finalprojectm;

import com.example.finalprojectm.LoginTest.PasswordValidation;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PasswordTest {
    PasswordValidation passwordValidation;

    @BeforeClass
    public static void beforeClass(){
        System.out.println("@beforeClass");

    }
    @Before
    public void before(){
        System.out.println("@before");
        passwordValidation = new PasswordValidation();
    }
    @Test
    public void test1(){

        assertTrue(passwordValidation.isValidPassword("1234567y89@Y"));

        System.out.println("Passwordtest1 success");
    }

    @Test
    public void test2(){

        assertFalse(passwordValidation.isValidPassword("123456789@"));

        System.out.println("Passwordtest1 success");

    }

    @Test
    public void test3(){

        assertFalse(passwordValidation.isValidPassword(null));
        System.out.println("Passwordtest2 success");
    }
    @Test
    public void test4(){

        assertFalse(passwordValidation.isValidPassword("123456789@1111!@@#dvdbvdbw##00"));
        System.out.println("Passwordtest4 success");

    }
    @Test
    public void test5(){

        assertFalse(passwordValidation.isValidPassword(""));
        System.out.println("Passwordtest5 success");
    }
    @After
    public void after(){
        System.out.println("@after");

    }
    @AfterClass
    public static void afterClass(){
        System.out.println("@afterClass");

    }

}
