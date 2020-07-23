package com.jeancar.dbdutilidades.viewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.jeancar.dbdutilidades.classes.Killer;
import com.jeancar.dbdutilidades.dataBase.KillerRepository;

import java.util.List;

public class KillersViewModel extends AndroidViewModel {

    private KillerRepository killerRepository;
    private LiveData<List<Killer>> lDkiller;

    public KillersViewModel (Application application){
        super(application);
        killerRepository = new KillerRepository(application);
        lDkiller = killerRepository.getAllKillers();
    }

    public LiveData<List<Killer>> getlDkiller(){return lDkiller;}

    public void insert(List<Killer> killers){killerRepository.insert(killers);}
    public void updateAll(List<Killer> killers){killerRepository.updateAll(killers);}

}
