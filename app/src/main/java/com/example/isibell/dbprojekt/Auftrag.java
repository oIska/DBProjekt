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

}
