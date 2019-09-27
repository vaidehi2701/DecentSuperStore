package com.example.decentsuperstore.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

import com.example.decentsuperstore.Activity.MainActivity;
import com.example.decentsuperstore.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomAddressFragment extends BottomSheetDialogFragment {


    public static BottomAddressFragment getInstance() {
        return new BottomAddressFragment();
    }

    AlertDialog.Builder builder;
    public Button btnContinue;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.bottom_address, container, false);

        btnContinue = view.findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPayment();
            }
           }
        );
        return view;
    }

    private void openPayment() {

        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.payment_ui, null);


        builder = new AlertDialog.Builder(getActivity());
        Button btnBook = alertLayout.findViewById(R.id.btnBook);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View alertLayout = inflater.inflate(R.layout.custom_book, null);
                TextView tvOk = alertLayout.findViewById(R.id.tvOk);
                tvOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(getActivity(),MainActivity.class);
                        startActivity(intent);
                    }
                });

                builder = new AlertDialog.Builder(getActivity());
                builder.setView(alertLayout);


                final AlertDialog alert = builder.create();

                alert.show();
            }
        });
        builder.setView(alertLayout);


        final AlertDialog alert = builder.create();
        alert.show();


    }

}


