package com.example.finalprojectm;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HashemRegisterActivityTest {

    RegisterActivity registerActivity;

    @Before
    public void SetUp(){
        registerActivity = new RegisterActivity();
    }

    @Test
    public void ValidEmailAddress_test1()throws Exception{
        Assert.assertTrue("Email is Valid",registerActivity.isValidEmail("hashem@gmail.com"));
    }
}
