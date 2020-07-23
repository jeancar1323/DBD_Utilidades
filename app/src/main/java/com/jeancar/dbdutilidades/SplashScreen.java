package com.jeancar.dbdutilidades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.jeancar.dbdutilidades.classes.Killer;

import com.jeancar.dbdutilidades.classes.KillerDao;
import com.jeancar.dbdutilidades.dataBase.AppDataBase;
import com.jeancar.dbdutilidades.utils.Populate;
import com.jeancar.dbdutilidades.utils.SharedPref;
import com.jeancar.dbdutilidades.viewModels.KillersViewModel;

import java.lang.ref.WeakReference;
import java.util.List;

public class SplashScreen extends AppCompatActivity {


    SharedPref sharedPref;
    AppDataBase db;
    KillersViewModel killersViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //new PopAsyncTask(this).execute();
        killersViewModel = new ViewModelProvider(this).get(KillersViewModel.class);
        
        sharedPref = new SharedPref(this);
        if (sharedPref.isFirstTime()){
            //primeira vez do app rodar
            killersViewModel.insert(Populate.populateKiller());
            sharedPref.setFirstTime();
        }
        changeActivity();

    }

    public void changeActivity(){
        new Handler().postDelayed(() -> {
            startActivity(new Intent(this,MainActivity.class));
        },1000);
    }




}