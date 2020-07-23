package com.jeancar.dbdutilidades.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jeancar.dbdutilidades.R;
import com.jeancar.dbdutilidades.adapters.Adpter_Personagens;
import com.jeancar.dbdutilidades.classes.Killer;
import com.jeancar.dbdutilidades.utils.GridSpacingItemDecoration;
import com.jeancar.dbdutilidades.utils.Populate;
import com.jeancar.dbdutilidades.viewModels.KillersViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private KillersViewModel killersViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }


    RecyclerView rcPersonagens;
    Adpter_Personagens adpter_personagens;
    Context context;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.main_fragment, container, false);
        rcPersonagens = v.findViewById(R.id.rcPersonagens);
        context = getContext();
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        killersViewModel = new ViewModelProvider(this).get(KillersViewModel.class);
        adpter_personagens = new Adpter_Personagens(context);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(context, 2);
        rcPersonagens.setLayoutManager(mLayoutManager);
        rcPersonagens.addItemDecoration(new GridSpacingItemDecoration(2, GridSpacingItemDecoration.dpToPx(context,5), true));
        rcPersonagens.setItemAnimator(new DefaultItemAnimator());
        rcPersonagens.setAdapter(adpter_personagens);
        killersViewModel.getlDkiller().observe(getViewLifecycleOwner(),killersObserver());
    }

    public Observer<List<Killer>> killersObserver(){
        return killers -> {
            adpter_personagens.setKillers(killers);
        };
    }

    @Override
    public void onPause() {
        super.onPause();
        killersViewModel.updateAll(adpter_personagens.getKillerList());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        killersViewModel.updateAll(adpter_personagens.getKillerList());

    }
}
