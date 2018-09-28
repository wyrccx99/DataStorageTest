package com.example.ccx.datastoragetest;

import android.app.Application;

import xiaofei.library.datastorage.IDataStorage;


/**
 * Created by ccx on 18/09/21.
 */

public class BaseApplication extends Application {
    private static BaseApplication instance;
    public static IDataStorage dataStorage = null;

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;
    }

    public static BaseApplication getInstance() {
        return instance;
    }
}
