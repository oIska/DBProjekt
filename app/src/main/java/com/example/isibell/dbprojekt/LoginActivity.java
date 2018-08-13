package com.example.isibell.dbprojekt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText userNameEditText;
    private EditText passwordTextView;
    private Button loginButton;

    private String userNameInput;
    private String userPasswordInput;

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

                userNameInput = userNameEditText.getText().toString();
                userPasswordInput = passwordTextView.getText().toString();

                if (userNameInput.equals("Manager") && userPasswordInput.equals("manager")){
                    Intent managerIntent = new Intent(LoginActivity.this, ManagerActivity.class);
                    startActivity(managerIntent);
                } else if (userNameInput.equals("Fahrer1") && userPasswordInput.equals("fahrer")){
                    Intent driverIntent = new Intent(LoginActivity.this, DriverActivity.class);
                    driverIntent.putExtra("PersNr", 1);
                    startActivity(driverIntent);
                } else if (userNameInput.equals("Fahrer2") && userPasswordInput.equals("fahrer")){
                    Intent driverIntent = new Intent(LoginActivity.this, DriverActivity.class);
                    driverIntent.putExtra("PersNr", 2);
                    startActivity(driverIntent);
                } else if (userNameInput.equals("Fahrer3") && userPasswordInput.equals("fahrer")){
                    Intent driverIntent = new Intent(LoginActivity.this, DriverActivity.class);
                    driverIntent.putExtra("PersNr", 3);
                    startActivity(driverIntent);
                }
            }
        });

    }
}
