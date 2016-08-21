package com.example.user.database;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    TextView usr, pass;
    EditText etUsername, etPassword;
    Button bLogin;
    CheckBox chk;
    ImageView imageView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usr               = (TextView) findViewById(R.id.usr);
        pass              = (TextView) findViewById(R.id.pass);
        etUsername        = (EditText) findViewById(R.id.etUsername);
        etPassword        = (EditText) findViewById(R.id.etPassword);
        bLogin            = (Button) findViewById(R.id.bLogin);
        chk               = (CheckBox) findViewById(R.id.chk);
        imageView         = (ImageView) findViewById(R.id.imageView);



        bLogin.setOnClickListener(this);
        chk.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch(v.getId()){


            case R.id.bLogin:
                if (etUsername.getText().toString().contains(" ")) {
                    etUsername.setError("No Spaces Allowed");
                    Toast.makeText(this, "No Spaces Allowed", Toast.LENGTH_SHORT).show();
                    break;
                }
                int us = etUsername.getText().length();
                int pswrd = etPassword.getText().length();
                if(us >6 && pswrd >6){
                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                    break;
                }
                else
                    Toast.makeText(this, "Min 6 characters for username & password without spaces", Toast.LENGTH_SHORT).show();
                break;
            case R.id.chk:
                etPassword.setInputType((chk.isChecked())?InputType.TYPE_TEXT_VARIATION_NORMAL : InputType.TYPE_TEXT_VARIATION_PASSWORD);
                break;

        }
    }}
