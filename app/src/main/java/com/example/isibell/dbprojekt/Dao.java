package com.example.isibell.dbprojekt;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@android.arch.persistence.room.Dao
public interface Dao {

    @Insert
    public void addDriver(Driver driver);

    @Insert
    public void addOrder(Order order);

    @Query("SELECT * FROM `order` WHERE driverNr LIKE :persNr AND done LIKE :done")
    public Order getNewOrder(int persNr, boolean done);

}
