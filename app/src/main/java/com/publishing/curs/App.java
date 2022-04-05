package com.publishing.curs;

import android.app.Application;

import androidx.room.Room;

import com.publishing.curs.database.AppDatabase;

public class App extends Application {

    public static App instance;

    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        initDatabase();
    }

    public static App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }

    private void initDatabase() {
        database = Room.databaseBuilder(this, AppDatabase.class, "Curs.db")
                .createFromAsset("database/database.db")
                .fallbackToDestructiveMigration()
                .build();
    }
}
