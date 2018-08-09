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
    private boolean status;


}
