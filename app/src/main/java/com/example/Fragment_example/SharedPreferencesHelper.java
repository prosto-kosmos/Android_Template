package com.example.Fragment_example;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesHelper {
    public static final String SHARED_PREF_NAME = "SHARED_PREF_NAME";
    public static final String BUTTON_KEY = "ID";

    private SharedPreferences mSharedPreferences;

    public SharedPreferencesHelper(Context context) {
        // параметры - название файла и режим
        mSharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
    }

    public int getId(){
        return mSharedPreferences.getInt(BUTTON_KEY, -1);
    }

    public void addId(int id){
        mSharedPreferences.edit().putInt(BUTTON_KEY, id).apply();
    }
}
