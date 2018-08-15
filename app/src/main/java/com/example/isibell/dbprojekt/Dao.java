package com.example.isibell.dbprojekt;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

@android.arch.persistence.room.Dao
public interface Dao {

    @Insert
    public void addDriver(Driver driver);

    @Insert
    public void addOrder(Order order);

    @Query("SELECT * FROM driver WHERE PersNr LIKE :PersNr")
    public Driver getDriverFromID(int PersNr);

    @Query("SELECT startAdress FROM `order`")
    public int[] getStartAdresses();

    @Query("SELECT * FROM `order` WHERE startAdress LIKE :startAdress")
    public Order getNewOrder(int startAdress);

    @Query("UPDATE `order` SET done = :done WHERE OrderNr = :orderNr")
    public void setDone(boolean done, int orderNr);

    @Query("UPDATE `order` SET driverNr = :PersNr WHERE OrderNr = :orderNr")
    public void setDriverForOrder(int PersNr, int orderNr);

    @Query("UPDATE driver SET position = :newPosition WHERE PersNr = :PersNr")
    public void updatePosition(int newPosition, int PersNr);

    @Query("UPDATE driver SET onTour = :onTour WHERE PersNr = :PersNr")
    public void updateDriverStatus(boolean onTour, int PersNr);
}
