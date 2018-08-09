package com.example.isibell.dbprojekt;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Order {

    @PrimaryKey(autoGenerate = true)
    private int orderNr;

    private int startAdress;
    private int targetAdress;
    private int driverNr;
    private String timestamp;
    private boolean done;

    public int getOrderNr() {
        return orderNr;
    }

    public void setOrderNr(int orderNr) {
        this.orderNr = orderNr;
    }

    public int getStartAdress() {
        return startAdress;
    }

    public void setStartAdress(int startAdress) {
        this.startAdress = startAdress;
    }

    public int getTargetAdress() {
        return targetAdress;
    }

    public void setTargetAdress(int targetAdress) {
        this.targetAdress = targetAdress;
    }

    public int getDriverNr() {
        return driverNr;
    }

    public void setDriverNr(int driverNr) {
        this.driverNr = driverNr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
