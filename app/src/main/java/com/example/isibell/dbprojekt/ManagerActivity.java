package com.example.isibell.dbprojekt;

import android.support.v7.app.AppCompatActivity;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ManagerActivity extends AppCompatActivity {

    private AppDatabase db;

    private Button createOrderButton;
    private Button createDriverButton;

    private EditText startPositionEditText;
    private EditText targetPositionEditText;
    private EditText dirverNameEditText;

    private String startPositionText;
    private String targetPositionText;
    private String dirverNameText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database").build();


        createDriverButton = (Button) findViewById(R.id.button_create_driver);
        createOrderButton = (Button) findViewById(R.id.button_create_order);

        startPositionEditText = (EditText) findViewById(R.id.editText_start_position);
        targetPositionEditText = (EditText) findViewById(R.id.editText_target_position);
        dirverNameEditText = (EditText) findViewById(R.id.editText_name);



        createOrderButton.setOnClickListener(new View.OnClickListener() {
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

    }
}
