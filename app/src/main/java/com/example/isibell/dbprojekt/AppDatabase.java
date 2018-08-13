package com.example.isibell.dbprojekt;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Driver.class, Order.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract Dao Dao();
}
