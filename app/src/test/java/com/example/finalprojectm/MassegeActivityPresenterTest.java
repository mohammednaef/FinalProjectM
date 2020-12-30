package com.example.finalprojectm;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class MassegeActivityPresenterTest {
    MassegeActivityPresenter massegeActivityPresenter;
    @Mock
    MassegeActivityInterface massegeActivityInterface;
    @Before
    public void testbefor()throws Exception{
       massegeActivityPresenter=new MassegeActivityPresenter(massegeActivityInterface);
    }
    @Test
    public void testReadMessage(){
        String sender="mahmoud";
        String reciver="Adel";

        massegeActivityPresenter.ReadMessage(sender,reciver);
        Mockito.verify(massegeActivityInterface).ReadMessage(sender,reciver);
    }
    @Test
    public void testSendMessage(){
        String sender="mahmoud";
        String reciver="Adel";
        String massege="Hello";

        massegeActivityPresenter.SendMessage(sender,reciver,massege);
        Mockito.verify(massegeActivityInterface).SendMessage(sender,reciver,massege);
    }

}