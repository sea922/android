package com.example.mhmcalculator;

import android.content.Context;

public class DataLocalManager {
    public static final String INIT_VALUE = "INIT_VALUE";
    private static DataLocalManager instance;
    private MySharedPreferences mySharedPreferences;

    public static void init(Context context){
        instance = new DataLocalManager();
        instance.mySharedPreferences = new MySharedPreferences(context);
    }
    public static DataLocalManager getInstance() {
        if(instance == null) {
            instance = new DataLocalManager();
        }
        return instance;
    }
    public void setValue(float value){
        //DataLocalManager.getInstance().mySharedPreferences.putNumberValue(INIT_VALUE, value);
    }
    public void getValue(){
        //DataLocalManager.getInstance().mySharedPreferences.getNumberValue(INIT_VALUE);
    }
}
