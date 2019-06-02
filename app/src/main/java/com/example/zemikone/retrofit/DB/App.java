package com.example.zemikone.retrofit.DB;

import android.app.Application;
import android.arch.persistence.room.Room;
import com.facebook.stetho.Stetho;

public class App extends Application {

    public static App INSTANCE;
    private Db db;
    private static final String DATABASE_NAME = "recipes_db";

    @Override
    public void onCreate() {

        super.onCreate();

        Stetho.initializeWithDefaults(this);

        db = Room.databaseBuilder(this,
                Db.class, DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        INSTANCE = this;
    }

    public static App get() {
        return INSTANCE;
    }

    public Db getDb() {
        return db;
    }

}
