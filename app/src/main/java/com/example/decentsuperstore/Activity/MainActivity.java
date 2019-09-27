package com.example.decentsuperstore.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.example.decentsuperstore.Adapter.BrandAdapter;
import com.example.decentsuperstore.Adapter.CategoryAdapter;
import com.example.decentsuperstore.Model.BrandIcon;
import com.example.decentsuperstore.Model.CategoryModel;
import com.example.decentsuperstore.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView rvCategory,rvBrandCategory;
    private CategoryAdapter categoryAdapter;
    private BrandAdapter brand_adapter;
    private ArrayList<CategoryModel> CategoryPic;
    private ArrayList<BrandIcon> BrandPic;
    AlertDialog.Builder builder;
    private Button btnCancel,btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        rvCategory = findViewById(R.id.rvCategory);
        rvBrandCategory = findViewById(R.id.rvBrandCategory);

        setSupportActionBar(toolbar);
        toolbar.setTitle("Decent SuperStore");


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_list);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);



        rvCategory.setHasFixedSize(true);
        rvBrandCategory.setHasFixedSize(true);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rvCategory.setLayoutManager(gridLayoutManager);
        setDummyData();
        categoryAdapter = new CategoryAdapter(CategoryPic, this);
        rvCategory.setAdapter(categoryAdapter);

        GridLayoutManager layoutManager1 = new GridLayoutManager(this, 3);

        setBrandIcon();
        rvBrandCategory.setLayoutManager(layoutManager1);
        brand_adapter = new BrandAdapter(this, BrandPic);
        rvBrandCategory.setAdapter(brand_adapter);






    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_history) {
            Intent intent=new Intent(this,HistoryActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_Home) {
            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return false;

        } else if (id == R.id.nav_Profile) {
            Intent intent=new Intent(this,ProfileActivity.class);
            startActivity(intent);


        } else if (id == R.id.nav_rating) {
           openRatingBox();

        } else if (id == R.id.nav_Contact) {
             Intent intent=new Intent(this,ContactActivity.class);
             startActivity(intent);

        } else if (id == R.id.nav_logout) {
            Intent intent = new Intent(this, LoginScreen.class);
            startActivity(intent);
            finish();


        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void openRatingBox() {

        LayoutInflater inflater = getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.layout_custom_dialog, null);


        builder = new AlertDialog.Builder(this);
        builder.setView(alertLayout);

        builder.setMessage("How was your experience? Rate our application.")
                .setCancelable(false);
        //Creating dialog box


        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getBaseContext(), "Cancel clicked", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getBaseContext(), "Thanks For Rating Us", Toast.LENGTH_SHORT).show();
            }
        });
        final AlertDialog alert = builder.create();
        alert.show();



    }


    private void setDummyData() {
        CategoryPic = new ArrayList<>();
        CategoryPic.add(new CategoryModel(R.drawable.cat1));
        CategoryPic.add(new CategoryModel(R.drawable.cat2));
        CategoryPic.add(new CategoryModel(R.drawable.cat3));
        CategoryPic.add(new CategoryModel(R.drawable.cat4 ));
        CategoryPic.add(new CategoryModel(R.drawable.cat5 ));
        CategoryPic.add(new CategoryModel(R.drawable.cat6));

    }

    private void setBrandIcon() {
        BrandPic = new ArrayList<>();
        BrandPic.add(new BrandIcon(R.drawable.b1));
        BrandPic.add(new BrandIcon(R.drawable.b2));
        BrandPic.add(new BrandIcon(R.drawable.b3));
        BrandPic.add(new BrandIcon(R.drawable.b4 ));
        BrandPic.add(new BrandIcon(R.drawable.b5 ));
        BrandPic.add(new BrandIcon(R.drawable.b6));
    }

}
