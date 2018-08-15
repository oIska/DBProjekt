package com.example.isibell.dbprojekt;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DriverActivity extends AppCompatActivity {
    private Button getOrderButton, orderDoneButton;
    private TextView targetPositionView;

    private AppDatabase database;

    private Order newOrder;
    private Driver driver;
    private int PersNr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fahrer);

        initUI();
        readIntent();

        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database").allowMainThreadQueries().build();


        getOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                driver = database.Dao().getDriverFromID(PersNr);

                // Startadressen aus DB holen, neuen Auftrag annehmen, Fahrerstatus aktualisieren
                int[] startPositions = database.Dao().getStartAdresses(false, 0);

                int minDiff = 20;
                int newStartPosition = 0;

                String driverPosition = String.valueOf(driver.getPosition());
                Log.d("LOG_DRIVERPOSIOTION", driverPosition);

                for (int i = 0; i < startPositions.length; i++){
                    String adress = String.valueOf(startPositions[i]);
                    Log.d("LOG_ORDERADRESS", adress);

                    int intermediary = Math.abs(adress.charAt(0) - driverPosition.charAt(0)) + Math.abs(adress.charAt(1) - driverPosition.charAt(1));
                    if (intermediary < minDiff){
                        minDiff = intermediary;
                        newStartPosition = startPositions[i];
                    }
                }

                newOrder = database.Dao().getNewOrder(newStartPosition);

                String target = String.valueOf(newOrder.getTargetAdress());
                targetPositionView.setText("Your next tour: " + newStartPosition + " to " + target);

                database.Dao().updateDriverStatus(true, PersNr);
                database.Dao().setDriverForOrder(PersNr, newOrder.getOrderNr());

            }
        });

        orderDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Auftrag als erledigt markieren, Fahrerposition aktualisieren und Fahrerstatus aktualisieren
                database.Dao().setDone(true, newOrder.getOrderNr());
                database.Dao().updatePosition(newOrder.getTargetAdress(), PersNr);

                Driver driver2 = database.Dao().getDriverFromID(PersNr);
                Log.d("UPDATE_POSITION", String.valueOf(driver2.getPosition()));

                database.Dao().updateDriverStatus(false, PersNr);

                targetPositionView.setText("New target...");
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
