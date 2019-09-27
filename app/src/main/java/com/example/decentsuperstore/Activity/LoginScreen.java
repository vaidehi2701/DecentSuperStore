package com.example.decentsuperstore.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.decentsuperstore.R;

public class LoginScreen extends AppCompatActivity implements View.OnClickListener {

    private TextView tvSignUp;
    private Button btnSignIn;
    private EditText etNumber, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);

        etNumber = findViewById(R.id.etNumber);
        etPassword = findViewById(R.id.etPassword);

        tvSignUp = findViewById(R.id.tvSignUp);
        tvSignUp.setOnClickListener(this);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tvSignUp:
                Intent intent = new Intent(this, SignUp.class);
                startActivity(intent);
                break;
            case R.id.btnSignIn:
               login(view);
                break;

        }
    }

    public void login(View view) {
        if (etNumber.getText().toString().equals("8200002011") && etPassword.getText().toString().equals("admin")) {

            Intent intent1 = new Intent(this, MainActivity.class);
            startActivity(intent1);
        } else {
            Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
        }
    }
}
