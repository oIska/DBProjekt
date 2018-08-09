package com.example.isibell.dbprojekt;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@android.arch.persistence.room.Dao
public interface Dao {
    @Insert
    void insertDriver(Driver... drivers);

    @Query("SELECT * FROM driver")
    List<Driver> getAll();


}
