package com.example.decentsuperstore.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.decentsuperstore.Adapter.Pager;
import com.example.decentsuperstore.Fragment.Fragment1;
import com.example.decentsuperstore.Fragment.Fragment2;
import com.example.decentsuperstore.R;
import com.google.android.material.tabs.TabLayout;

public class DetailActivity extends AppCompatActivity {

    public TextView integer_number;
    public Button btnIncrease, btnDecrease;
    int counter = 0;
    private ViewPager vpTab;
    private TabLayout tabLayout;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        btnIncrease = findViewById(R.id.btnIncrease);
        btnDecrease = findViewById(R.id.btnDecrease);
        integer_number =findViewById(R.id.integer_number);
        vpTab=findViewById(R.id.vpTab);
        tabLayout=findViewById(R.id.tabLayout);

//
        tabLayout.setupWithViewPager(vpTab);

        setupViewPager(vpTab);
        setupTabIcons();
        setUpToolbar();
    }



    private void setupViewPager(ViewPager viewPager) {
        Pager adapter = new Pager(getSupportFragmentManager());
        adapter.addFragment(new Fragment1(), "ONE");
        adapter.addFragment(new Fragment2(), "TWO");
        viewPager.setAdapter(adapter);
    }
    private void setupTabIcons() {
        tabLayout.getTabAt(0).setText("Description");
        tabLayout.getTabAt(1).setText("Usages");

    }
    private void setUpToolbar() {

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }


        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }
}
