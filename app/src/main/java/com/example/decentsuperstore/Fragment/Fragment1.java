package com.example.decentsuperstore.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.decentsuperstore.R;

public class Fragment1 extends Fragment {

    public Button btnIncrease, btnDecrease;
    public TextView integer_number;
    int counter = 0;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        btnIncrease = view.findViewById(R.id.btnIncrease);
        btnDecrease = view.findViewById(R.id.btnDecrease);

        btnIncrease.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            counter = counter + 1;
            integer_number.setText(String.valueOf(counter));

        }
    });

        btnDecrease.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            counter = counter - 1;
            integer_number.setText(String.valueOf(counter));

        }
    });
        return view;

    }
}
