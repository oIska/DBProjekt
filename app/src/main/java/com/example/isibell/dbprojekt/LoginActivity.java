package com.example.isibell.dbprojekt;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginActivity extends AppCompatActivity {
    private EditText userNameEditText;
    private EditText passwordTextView;
    private Button loginButton;

    private String userNameInput;
    private String userPasswordInput;

    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameEditText = (EditText) findViewById(R.id.userNameEditText);
        passwordTextView = (EditText) findViewById(R.id.userPasswordEditText);
        loginButton = (Button) findViewById(R.id.loginButton);

        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database").allowMainThreadQueries().build();


        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (isFirstRun){
            addDriverTestcases();
            addOrderTestcases();
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).commit();
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userNameInput = userNameEditText.getText().toString();
                userPasswordInput = passwordTextView.getText().toString();

                userNameEditText.setText("");
                passwordTextView.setText("");

                if (userNameInput.equals("Manager") && userPasswordInput.equals("manager")) {
                    Intent managerIntent = new Intent(LoginActivity.this, ManagerActivity.class);
                    startActivity(managerIntent);
                } else if (userPasswordInput.equals("fahrer")) {
                    int persNr = Integer.parseInt(userNameInput);
                    Intent driverIntent = new Intent(LoginActivity.this, DriverActivity.class);
                    driverIntent.putExtra("PersNr", persNr);
                    startActivity(driverIntent);
                }
            }
        });

    }

    private void addOrderTestcases() {

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(new Date());

        Order o1 = new Order();
        o1.setOrderNr(1);
        o1.setDone(false);
        o1.setStartAdress(33);
        o1.setTargetAdress(45);
        o1.setTimestamp(timeStamp);
        o1.setDriverNr(0);
        db.Dao().addOrder(o1);

        Order o2 = new Order();
        o2.setDone(false);
        o2.setStartAdress(12);
        o2.setTargetAdress(99);
        o2.setTimestamp(timeStamp);
        o2.setDriverNr(0);
        db.Dao().addOrder(o2);

        Order o3 = new Order();
        o3.setDone(false);
        o3.setStartAdress(35);
        o3.setTargetAdress(67);
        o3.setTimestamp(timeStamp);
        o3.setDriverNr(0);
        db.Dao().addOrder(o3);

        Order o4 = new Order();
        o4.setDone(false);
        o4.setStartAdress(67);
        o4.setTargetAdress(85);
        o4.setTimestamp(timeStamp);
        o4.setDriverNr(0);
        db.Dao().addOrder(o4);

        Order o5 = new Order();
        o5.setDone(false);
        o5.setStartAdress(94);
        o5.setTargetAdress(43);
        o5.setTimestamp(timeStamp);
        o5.setDriverNr(0);
        db.Dao().addOrder(o5);

        String order = "";
        Order[] orders = db.Dao().getAllOrders();
        for (Order o : orders) {
            int p = o.getOrderNr();
            order += p;
        }
        Log.d("TAG_DRIVER", order);
    }

    private void addDriverTestcases() {
        Driver d1 = new Driver();
        d1.setName("Hans Müller");
        d1.setPersNr(1);
        d1.setPosition(11);
        d1.setOnTour(false);
        db.Dao().addDriver(d1);

        Driver d2 = new Driver();
        d2.setName("Hans Meier");
        d2.setPosition(11);
        d2.setOnTour(false);
        db.Dao().addDriver(d2);

        Driver d3 = new Driver();
        d3.setName("Hans Wurster");
        d3.setPosition(11);
        d3.setOnTour(false);
        db.Dao().addDriver(d3);

        String pers = "";
        Driver[] drivers = db.Dao().getAllDriver();
        for (Driver d : drivers) {
            int p = d.getPersNr();
            pers += p;
        }
        Log.d("TAG_DRIVER", pers);
    }
}
