package com.jeancar.dbdutilidades.dataBase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.jeancar.dbdutilidades.classes.Killer;
import com.jeancar.dbdutilidades.classes.KillerDao;
import com.jeancar.dbdutilidades.utils.Populate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Killer.class}, version = 1,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {

    public abstract KillerDao killerDao();

    private static volatile AppDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public  static AppDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDataBase.class, "dbdutilidades_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
