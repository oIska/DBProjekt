package com.example.isibell.dbprojekt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        userNameEingabe = userNameEditText.getText().toString();
        userPasswordEingabe = passwordTextView.getText().toString();



        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // funktioniert nicht ....
                if (userNameEingabe.contentEquals("@string/managerNameLogin") && userPasswordEingabe.contentEquals("@string/managerPasswordLogin")){
                    Intent intent = new Intent(LoginActivity.this, ManagerActivity.class);
                    startActivity(intent);
                }else if (userNameEingabe.contentEquals("@string/driverNameLogin") && userPasswordEingabe.contentEquals("@string/driverPasswordLogin")){
                    Intent intent = new Intent(LoginActivity.this, FahrerActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
