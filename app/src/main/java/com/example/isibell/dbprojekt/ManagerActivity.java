package com.example.isibell.dbprojekt;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ManagerActivity extends AppCompatActivity {

    private Button createOrderButton;
    private Button createDriverButton;

    private EditText startPositionEditText;
    private EditText targetPositionEditText;
    private EditText dirverNameEditText;

    private int startPositionText;
    private int targetPositionText;
    private String dirverNameText;

    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        createDriverButton = (Button) findViewById(R.id.button_create_driver);
        createOrderButton = (Button) findViewById(R.id.button_create_order);

        startPositionEditText = (EditText) findViewById(R.id.editText_start_position);
        targetPositionEditText = (EditText) findViewById(R.id.editText_target_position);
        dirverNameEditText = (EditText) findViewById(R.id.editText_name);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database").allowMainThreadQueries().build();

        createOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startPositionText = Integer.parseInt(startPositionEditText.getText().toString());
               targetPositionText = Integer.parseInt(targetPositionEditText.getText().toString());
               String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(new Date());

               Order nextOrder = new Order();
               nextOrder.setDone(false);
               nextOrder.setStartAdress(startPositionText);
               nextOrder.setTargetAdress(targetPositionText);
               nextOrder.setTimestamp(timeStamp);
               nextOrder.setDriverNr(0);
               db.Dao().addOrder(nextOrder);
            }
        });

        createDriverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dirverNameText = dirverNameEditText.getText().toString();

                Driver nextDriver = new Driver();
                nextDriver.setName(dirverNameText);
                nextDriver.setPosition(00);
                nextDriver.setOnTour(false);
                db.Dao().addDriver(nextDriver);
            }
        });

    }
}

/*  createOrderButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        // die sollten ja auch integer sein wie konvertiert man hier richtig zu nem Integer ?
        startPositionText = startPositionEditText.getText().toString();
        targetPositionText = targetPositionEditText.getText().toString();

        // Auftrag nextAuftrag = new Auftrag();
        //nextAuftrag.setZielstandort(targetPositionText);
        // eine funktion für timestamp suchen
        //alle sachen belegen

        // Hannes fragen wo den Auftragsbearbeitungs algorithmus hinpacken weil es theoretisch überall funktionieren muss


        }
        });

        createDriverButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        dirverNameText = dirverNameEditText.getText().toString();
        Driver nextDriver = new Driver();
        nextDriver.setName(dirverNameText);
        nextDriver.setPosition(new int[0][0]);
        nextDriver.setOnTour(false);
        db.Dao().insertDriver(nextDriver);
        }
        });
*/