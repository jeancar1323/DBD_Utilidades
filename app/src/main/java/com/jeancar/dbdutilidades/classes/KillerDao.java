package com.jeancar.dbdutilidades.classes;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface KillerDao {

    @Query("SELECT * FROM Killer")
    LiveData<List<Killer>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(List<Killer> killers);

    @Delete
    void delete(Killer killer);

    @Update
    void updateAll(List<Killer> killers);

}
