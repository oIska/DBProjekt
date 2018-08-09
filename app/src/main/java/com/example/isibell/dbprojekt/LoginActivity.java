package com.example.isibell.dbprojekt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private EditText userNameEditText;
    private EditText passwordTextView;
    private Button loginButton;

    private String userNameEingabe;
    private String userPasswordEingabe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userNameEditText = (EditText)findViewById(R.id.userNameEditText);
        passwordTextView = (EditText)findViewById(R.id.userPasswordEditText);
        loginButton = (Button) findViewById(R.id.loginButton);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userNameEingabe = userNameEditText.getText().toString();
                userPasswordEingabe = passwordTextView.getText().toString();

                if (userNameEingabe.equals("Manager") && userPasswordEingabe.equals("manager")){
                    Intent managerIntent = new Intent(LoginActivity.this, ManagerActivity.class);
                    startActivity(managerIntent);
                } else if (userNameEingabe.equals("Fahrer") && userPasswordEingabe.equals("fahrer")){
                    Intent driverIntent = new Intent(LoginActivity.this, FahrerActivity.class);
                    startActivity(driverIntent);
                }
            }
        });

    }
}
