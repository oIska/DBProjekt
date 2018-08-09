package com.example.isibell.dbprojekt;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FahrerActivity extends AppCompatActivity {
    private Button getOrderButton, orderDoneButton;
    private TextView targetPositionView;
    private int PersNr;

    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fahrer);

        initUI();
        readIntent();

        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database").build();

        getOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        orderDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }

    private void initUI() {
        getOrderButton = (Button) findViewById(R.id.button_get_order);
        orderDoneButton = (Button) findViewById(R.id.button_order_done);
        targetPositionView = (TextView) findViewById(R.id.text_target_adress);
    }

    private void readIntent() {
        Intent i = getIntent();
        Bundle extras = i.getExtras();
        PersNr = extras.getInt("PersNr");
    }
}
