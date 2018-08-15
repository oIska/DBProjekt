package com.example.isibell.dbprojekt;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ManagerActivity extends AppCompatActivity {

    private Button createOrderButton, createDriverButton, updateDriverButton;

    private EditText startPositionEditText, targetPositionEditText, driverNameEditText, driverIdEditText, driverNewNameEditText;

    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        initUI();
        initDB();

        createOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewOrderToDB();
            }
        });

        createDriverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNewDriverToDB();
            }
        });

        updateDriverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDriverName();
            }
        });

    }

    private void initDB() {
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database").allowMainThreadQueries().build();
    }

    private void updateDriverName() {
        int persNr = Integer.parseInt(driverIdEditText.getText().toString());
        db.Dao().updateDriverName(driverNewNameEditText.getText().toString(), persNr);

        Toast.makeText(getApplicationContext(), "DB action successful", Toast.LENGTH_LONG).show();
    }

    private void addNewDriverToDB() {
        String driverNameText = driverNameEditText.getText().toString();

        Driver nextDriver = new Driver();
        nextDriver.setName(driverNameText);
        nextDriver.setPosition(11);
        nextDriver.setOnTour(false);
        db.Dao().addDriver(nextDriver);

        Toast.makeText(getApplicationContext(), "DB action successful", Toast.LENGTH_LONG).show();
    }

    private void addNewOrderToDB() {
        int startPositionText = Integer.parseInt(startPositionEditText.getText().toString());
        int targetPositionText = Integer.parseInt(targetPositionEditText.getText().toString());
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(new Date());

        Order nextOrder = new Order();
        nextOrder.setDone(false);
        nextOrder.setStartAdress(startPositionText);
        nextOrder.setTargetAdress(targetPositionText);
        nextOrder.setTimestamp(timeStamp);
        nextOrder.setDriverNr(0);
        db.Dao().addOrder(nextOrder);

        Toast.makeText(getApplicationContext(), "DB action successful", Toast.LENGTH_LONG).show();
    }

    private void initUI() {
        createDriverButton = (Button) findViewById(R.id.button_create_driver);
        createOrderButton = (Button) findViewById(R.id.button_create_order);
        updateDriverButton = (Button) findViewById(R.id.button_updateDriver);

        startPositionEditText = (EditText) findViewById(R.id.editText_start_position);
        targetPositionEditText = (EditText) findViewById(R.id.editText_target_position);
        driverNameEditText = (EditText) findViewById(R.id.editText_name);
        driverIdEditText = (EditText) findViewById(R.id.editText_driverNr);
        driverNewNameEditText = (EditText) findViewById(R.id.editText_newDriverName);
    }
}
