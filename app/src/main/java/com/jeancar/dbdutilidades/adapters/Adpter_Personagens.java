package com.jeancar.dbdutilidades.adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jeancar.dbdutilidades.R;
import com.jeancar.dbdutilidades.classes.Killer;

import java.util.List;

public class Adpter_Personagens extends RecyclerView.Adapter<BaseViewHolder>  {

    private List<Killer> killerList;
    private Context context;


    public Adpter_Personagens( Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_personagens,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    public void setKillers(List<Killer> killerList){
        this.killerList = killerList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {

        return ((killerList != null) && (killerList.size() !=0) ) ? killerList.size() : 0;
    }

    public List<Killer> getKillerList(){
        return killerList;
    }


    class ViewHolder extends BaseViewHolder{

        ImageView ivFoto;
        ConstraintLayout container;


        ViewHolder(@NonNull View v) {
            super(v);
           ivFoto = v.findViewById(R.id.imgFoto);
           container = v.findViewById(R.id.container);

        }

        @Override
        public void onBind(final int position) {
            super.onBind(position);
            final Killer killer = killerList.get(position);
            Glide.with(context).load(killer.getFoto()).centerCrop()
                    .into(ivFoto);
            container.getBackground().setAlpha(128);
            if (killer.isAdpto()){
                ivFoto.setImageAlpha(255);
            }else {
                ivFoto.setImageAlpha(128);
            }

            ivFoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (killerList.get(position).isAdpto()){
                        ivFoto.setImageAlpha(128);
                        killerList.get(position).setAdpto(false);
                    }else {
                        ivFoto.setImageAlpha(255);
                        killerList.get(position).setAdpto(true);
                    }
                }
            });

        }

        @Override
        protected void clear() {

        }
    }



}
