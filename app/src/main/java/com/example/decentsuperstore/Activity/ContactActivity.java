package com.example.decentsuperstore.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.decentsuperstore.Adapter.ContactAdapter;
import com.example.decentsuperstore.Model.ContactModel;
import com.example.decentsuperstore.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {

    private RecyclerView rvContact;
    AlertDialog.Builder builder;
    private ContactAdapter contactAdapter;
    private List<ContactModel> contactModels = new ArrayList<>();
    private Menu menu;
    private Toolbar toolbar;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvContact = findViewById(R.id.rvContact);

        AppBarLayout mAppBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    isShow = true;
                    showOption(R.id.action_info);
                } else if (isShow) {
                    isShow = false;
                    hideOption(R.id.action_info);
                }
            }
        });


        contactAdapter = new ContactAdapter(contactModels);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);


        rvContact.setLayoutManager(layoutManager);
        rvContact.setItemAnimator(new DefaultItemAnimator());
        rvContact.setAdapter(contactAdapter);


        setUpToolbar();
        setContactDetail();


    }

    private void setUpToolbar() {

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        hideOption(R.id.action_info);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_info) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void hideOption(int id) {
        MenuItem item = menu.findItem(id);
        item.setVisible(false);
    }

    private void showOption(int id) {
        MenuItem item = menu.findItem(id);
        item.setVisible(true);
    }



    public void onBackPressed() {

        super.onBackPressed();
    }



    private void setContactDetail() {

        ContactModel contactModel = new ContactModel("Vadodara Branch");
        contactModels.add(contactModel);

        contactModel = new ContactModel("Surat Branch");
        contactModels.add(contactModel);

        contactModel = new ContactModel("Ahemdabad Branch");
        contactModels.add(contactModel);

        contactModel = new ContactModel("Mumbai Branch");
        contactModels.add(contactModel);

        contactModel = new ContactModel("Pune Branch");
        contactModels.add(contactModel);

        contactModel = new ContactModel("Delhi Branch");
        contactModels.add(contactModel);

        contactModel = new ContactModel("Nagpur Branch");
        contactModels.add(contactModel);
    }

}
