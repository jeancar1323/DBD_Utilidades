package com.jeancar.dbdutilidades.utils;

import com.jeancar.dbdutilidades.R;
import com.jeancar.dbdutilidades.classes.Killer;

import java.util.ArrayList;
import java.util.List;

public class Populate {

    public static List<Killer> populateKiller(){
        List<Killer> killerList = new ArrayList<>();
        killerList.add(new Killer("O Caçador", R.drawable.trapper,false));
        killerList.add(new Killer("O Espectro", R.drawable.dingding,false));
        killerList.add(new Killer("O Caipira", R.drawable.hillbilly,false));
        killerList.add(new Killer("A Enfermeira", R.drawable.nurse,false));
        killerList.add(new Killer("A Caçadora", R.drawable.huntress,false));
        killerList.add(new Killer("O Vulto", R.drawable.maicao,false));
        killerList.add(new Killer("A Bruxa", R.drawable.hag,false));
        killerList.add(new Killer("O Médico", R.drawable.doctor,false));
        killerList.add(new Killer("O Canibal", R.drawable.bubba,false));
        killerList.add(new Killer("O Pesadelo", R.drawable.freddy,false));
        killerList.add(new Killer("A Porca", R.drawable.pig,false));
        killerList.add(new Killer("O Palhaço", R.drawable.palhaco,false));
        killerList.add(new Killer("A Espírito", R.drawable.spirit,false));
        killerList.add(new Killer("A Legião", R.drawable.legion,false));
        killerList.add(new Killer("A Praga", R.drawable.plage,false));
        killerList.add(new Killer("Ghost Face", R.drawable.ghost,false));
        killerList.add(new Killer("O Demongorgon", R.drawable.demon,false));
        killerList.add(new Killer("O Oni", R.drawable.oni,false));
        killerList.add(new Killer("O Mercenário", R.drawable.seumadruga,false));
        killerList.add(new Killer("O Carrasco", R.drawable.ph,false));
        return killerList;
    }



}
