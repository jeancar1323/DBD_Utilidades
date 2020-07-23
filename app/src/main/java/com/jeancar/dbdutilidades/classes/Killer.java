package com.jeancar.dbdutilidades.classes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Killer")
public class Killer {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "nome")
    private String nome;
    @ColumnInfo(name = "foto")
    private Integer foto;
    @ColumnInfo(name = "adpto")
    private  boolean adpto;

    public Killer(String nome, Integer foto, boolean adpto) {
        this.nome = nome;
        this.foto = foto;
        this.adpto = adpto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }

    public boolean isAdpto() {
        return adpto;
    }

    public void setAdpto(boolean adpto) {
        this.adpto = adpto;
    }
}
