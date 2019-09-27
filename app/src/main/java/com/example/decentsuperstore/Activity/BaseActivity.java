package com.example.decentsuperstore.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.decentsuperstore.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
