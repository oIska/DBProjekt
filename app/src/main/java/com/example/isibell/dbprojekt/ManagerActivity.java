package com.example.isibell.dbprojekt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ManagerActivity extends AppCompatActivity {

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

        createDriverButton = (Button) findViewById(R.id.button_create_driver);
        createOrderButton = (Button) findViewById(R.id.button_create_order);

        startPositionEditText = (EditText) findViewById(R.id.editText_start_position);
        targetPositionEditText = (EditText) findViewById(R.id.editText_target_position);
        dirverNameEditText = (EditText) findViewById(R.id.editText_name);

        createOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startPositionText = startPositionEditText.getText().toString();
               targetPositionText = targetPositionEditText.getText().toString();
            }
        });

        createDriverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dirverNameText = dirverNameEditText.getText().toString();
            }
        });

    }
}
