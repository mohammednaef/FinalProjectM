package com.example.finalprojectm;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class HashemRegisterActivityTest  {

    @Mock
    RegisterActivity registerActivity;

    @Before
    public void SetUp(){
        registerActivity = new RegisterActivity();
    }

    @Test
    public void ValidEmailAddress_test1()throws Exception{
        Assert.assertTrue("Email is Valid",registerActivity.isValidEmail("hashem@gmail.com"));
    }

    @Test
    public void inValidEmailAddress_test2()throws Exception{
        Assert.assertFalse("Email is Not Valid",registerActivity.isInValidEmail("hashemgmail.com"));
    }

    @Test
    public void inValidEmailAddress_test3()throws Exception{
        Assert.assertFalse("Email is Not Valid",registerActivity.isInValidEmail("hashem@.com"));
    }

    @Test
    public void inValidEmailAddress_test4()throws Exception{
        Assert.assertFalse("Email is Not Valid",registerActivity.isInValidEmail("hashem@gmail."));
    }

    @Test
    public void inValidEmailAddress_test5()throws Exception{
        Assert.assertFalse("Email is Not Valid",registerActivity.isInValidEmail("hashem@gmailcom"));
    }

    @Test
    public void isEmptyEmail_test6()throws Exception{
        Assert.assertFalse("Email is Empty",registerActivity.isEmptyEmail(""));
    }

    @Test
    public void isValidPassword_test7()throws Exception{
        Assert.assertTrue("Password is Valid",registerActivity.isValidPassword("123456"));
    }

    @Test
    public void isInValidPassword_test8()throws Exception{
     Assert.assertFalse("Password is inValid",registerActivity.isInValidPassword("1234"));
    }

    @Test
    public void isValidFullName_test9()throws Exception{
        Assert.assertTrue("Full Name is Valid",registerActivity.isValidFullName("Hashem Karam"));
    }

    @Test
    public void isInValidFullName_test10()throws Exception{
        Assert.assertFalse("Full Name is InValid",registerActivity.isInValidFullName("Hashem"));
    }

    @Test
    public void isValidPhone_test11()throws Exception{
        Assert.assertTrue("Phone is Valid",registerActivity.isValidPhone("0599478748"));
    }

    @Test
    public void isInValidPhone_test12()throws Exception{
        Assert.assertFalse("Phone is InValid",registerActivity.isInValidPhone("0599478"));
    }

}
