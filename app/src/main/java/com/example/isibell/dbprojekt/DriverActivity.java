package com.example.isibell.dbprojekt;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DriverActivity extends AppCompatActivity {
    private Button getOrderButton, orderDoneButton;
    private TextView targetPositionView;
    private int PersNr;

    private AppDatabase database;

    private Order newOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fahrer);

        initUI();
        readIntent();

        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database").allowMainThreadQueries().build();

        testOrder();

        getOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newOrder = database.Dao().getNewOrder(1, false);

                int adress = newOrder.getTargetAdress();
                String target = Integer.toString(adress);

                targetPositionView.setText(target);

            }
        });

        orderDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newOrder.setDone(true);
                targetPositionView.setText("New target...");
            }
        });

    }

    private void testOrder() {
        Order test = new Order();
        test.setDone(false);
        test.setStartAdress(23);
        test.setDriverNr(1);
        test.setTargetAdress(11);
        database.Dao().addOrder(test);

        Toast.makeText(getApplicationContext(), "Test DB", Toast.LENGTH_LONG).show();
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
