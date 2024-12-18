package com.example.trello;

import android.app.Application;

import com.example.trello.Utils.MySP;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initializeComponents();
    }


    private void initializeComponents() {
        MySP.init(this);
        SignalGenerator.init(this);
    }
}
