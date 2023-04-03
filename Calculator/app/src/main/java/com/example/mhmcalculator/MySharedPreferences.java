package com.example.mhmcalculator;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPreferences {
//    private static final String MY_SHARED_FREFERENCES = "MY_SHARED_FREFERENCES";
//    private Context mContext;
//
//    public MySharedPreferences(Context mContext) {
//        this.mContext = mContext;
//    }
//    public void putNumberValue(String key, float value){
//        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SHARED_FREFERENCES, Context.MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.putFloat(key, value);
//        editor.apply();
//    }
//    public float getNumberValue(String key){
//        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SHARED_FREFERENCES, Context.MODE_PRIVATE);
//        return sharedPreferences.getFloat(key, 0);
//    }
    private static final String PREF_NAME = "CalculatorPref";
    private static final String RESULT_KEY = "result";
    private static final String STRING_CALC = "strcal";
    private static final String OBJECT_CALC = "OBJECT_CALC";

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;


    public MySharedPreferences(Context context) {
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public void saveResult(String result) {
        editor.putString(RESULT_KEY, result);
        editor.apply();
    }

    public String getResult() {
        return pref.getString(RESULT_KEY, "");
    }
    public void saveStringCalc(String strcal) {
        editor.putString(STRING_CALC, strcal);
        editor.apply();
    }

    public String getStringCalc() {
        return pref.getString(STRING_CALC, "");
    }

}
