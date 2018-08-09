package com.example.isibell.dbprojekt;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Auftrag {

    @PrimaryKey(autoGenerate = true)
    private int auftragsNr;

    @ColumnInfo
    private int[][] abholstandort;

    @ColumnInfo
    private int[][] zielstandort;

    @ColumnInfo
    private int fahrerNr;

    @ColumnInfo
    private String timestamp;

    @ColumnInfo
    private boolean status;

    public int getAuftragsNr() {
        return auftragsNr;
    }

    public void setAuftragsNr(int auftragsNr) {
        this.auftragsNr = auftragsNr;
    }

    public int[][] getAbholstandort() {
        return abholstandort;
    }

    public void setAbholstandort(int[][] abholstandort) {
        this.abholstandort = abholstandort;
    }

    public int[][] getZielstandort() {
        return zielstandort;
    }

    public void setZielstandort(int[][] zielstandort) {
        this.zielstandort = zielstandort;
    }

    public int getFahrerNr() {
        return fahrerNr;
    }

    public void setFahrerNr(int fahrerNr) {
        this.fahrerNr = fahrerNr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
