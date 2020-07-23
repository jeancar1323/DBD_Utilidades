package com.jeancar.dbdutilidades.dataBase;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.jeancar.dbdutilidades.classes.Killer;
import com.jeancar.dbdutilidades.classes.KillerDao;

import java.util.List;

 public class KillerRepository {

    private KillerDao killerDao;
    private LiveData<List<Killer>> lDKiller;

    public KillerRepository(Application application){
        AppDataBase db = AppDataBase.getDatabase(application);
        killerDao = db.killerDao();
        lDKiller = killerDao.getAll();
    }

    public LiveData<List<Killer>> getAllKillers(){
        return lDKiller;
    }

   public void insert(List<Killer> killers){
        AppDataBase.databaseWriteExecutor.execute(()->{
            killerDao.insertAll(killers);
        });
    }
     public void updateAll(List<Killer> killers){
         AppDataBase.databaseWriteExecutor.execute(()->{
             killerDao.updateAll(killers);
         });
     }

}
