package com.example.finalprojectm;

import org.junit.After;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;
@RunWith(JUnit4.class)
public class UserTest {
    User user;
    @Before
    public void setUp() throws Exception {
         user=new User("1589","Mahmoud Adel Kheer Allah","majilkp@gmail.com","0565155845");
    }

    @After
    public void tearDown() throws Exception {
    }


    @Test
    public void getId() {
        assertEquals("1589",user.getId());
    }


    @Test
    public void getFullName() {
        assertEquals("Mahmoud Adel Kheer Allah",user.getFullName());
    }



    @Test
    public void getEmail() {
        assertEquals("majilkp@gmail.com",user.getEmail());
    }


    @Test
    public void getPhone() {
        assertEquals("0565155845",user.getPhone());
    }

}