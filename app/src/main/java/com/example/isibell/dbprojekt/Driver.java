package com.example.isibell.dbprojekt;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Driver {

    @PrimaryKey(autoGenerate = true)
    private int persNr;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo
    private int[][] position;

    @ColumnInfo
    private boolean onTour;

    public int getPersNr() {
        return persNr;
    }

    public void setPersNr(int persNr) {
        this.persNr = persNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[][] getPosition() {
        return position;
    }

    public void setPosition(int[][] position) {
        this.position = position;
    }

    public void setOnTour(boolean onTour) {
        this.onTour = onTour;
    }

    public boolean isOnTour() {

        return onTour;
    }
}
