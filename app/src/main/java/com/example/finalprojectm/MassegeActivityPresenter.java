package com.example.finalprojectm;

public class MassegeActivityPresenter implements MassegeActivityInterface{
    private MassegeActivityInterface view;
    public MassegeActivityPresenter(MassegeActivityInterface massegeActivityInterface){
        this.view=massegeActivityInterface;
    }

    @Override
    public void SendMessage(String sender, String reciver, String message) {

    }

    @Override
    public void ReadMessage(String myid, String heid) {

    }
}
