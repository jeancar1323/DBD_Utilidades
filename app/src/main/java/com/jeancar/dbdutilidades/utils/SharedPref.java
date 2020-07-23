package com.jeancar.dbdutilidades.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;


public class SharedPref {

    Activity context;
    SharedPreferences pref;
    Editor editor;


    public SharedPref(Activity context) {
        this.context = context;
        init();

    }

    public void init(){
        pref = PreferenceManager.getDefaultSharedPreferences(context);
        editor = pref.edit();
    }

    public boolean isFirstTime(){

      if (pref.getBoolean("firstTime",true)){
          return true;
      }else {
          return false;
      }

    }

    public void setFirstTime(){
        editor.putBoolean("firstTime", false);
        editor.apply();
    }

    public void clear(){
        editor.clear();
        editor.commit();
    }




}
