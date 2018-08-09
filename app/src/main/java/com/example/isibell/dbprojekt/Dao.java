package com.example.isibell.dbprojekt;

import android.arch.persistence.room.Insert;

@android.arch.persistence.room.Dao
public interface Dao {

    @Insert
    public void addDriver(Driver driver);



}
