package com.example.decentsuperstore.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.decentsuperstore.Adapter.GroceryAdapter;
import com.example.decentsuperstore.Adapter.ItemAdapter;
import com.example.decentsuperstore.Model.GroceryModel;
import com.example.decentsuperstore.Model.ItemModel;
import com.example.decentsuperstore.R;

import java.util.ArrayList;
import java.util.List;

public class GroceryList extends AppCompatActivity {

    private List<GroceryModel> groceryModels = new ArrayList<>();
    private RecyclerView rvItem;
    private GroceryAdapter groceryAdapter;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grocery_list);

            rvItem = findViewById(R.id.rvItem);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


            GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
            rvItem.setLayoutManager(layoutManager);
            groceryAdapter = new GroceryAdapter(this, groceryModels);
            rvItem.setAdapter(groceryAdapter);

//        itemAdapter = new ItemAdapter(itemModels);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        layoutManager.setOrientation(RecyclerView.VERTICAL);
//        rvItem.setLayoutManager(layoutManager);
//        rvItem.setItemAnimator(new DefaultItemAnimator());
//        rvItem.setAdapter(itemAdapter);

            setUpToolbar();
            AddItem();


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

        private void AddItem() {
            GroceryModel item1=new GroceryModel("Ankur Groundnut Oil","5 ltr"," Rs. 550",R.drawable.ankuroil);
            GroceryModel item2=new GroceryModel("Fortune Basmati Rice","1 kg "," Rs. 150",R.drawable.forturne_rice);
            GroceryModel item3=new GroceryModel("Dawat Basmati Rice","1 kg"," Rs. 190",R.drawable.dawat_rice);
            GroceryModel item4=new GroceryModel("Fortune Soya Oil","5 ltr "," Rs. 650",R.drawable.forturne_green);
            GroceryModel item5=new GroceryModel("PatanJali Sarso Oil","5 ltr "," Rs. 520",R.drawable.patanjali_oil);
            GroceryModel item6=new GroceryModel("Tata Salt","1 kg"," Rs. 35",R.drawable.tata_salt);
            GroceryModel item7=new GroceryModel("Ankur Groundnut Oil","5 ltr"," Rs. 550",R.drawable.ankuroil);
            GroceryModel item8=new GroceryModel("Fortune Basmati Rice","1 kg "," Rs. 150",R.drawable.forturne_rice);
            GroceryModel item9=new GroceryModel("Dawat Basmati Rice","1 kg"," Rs. 190",R.drawable.dawat_rice);

            groceryModels.add(item1);
            groceryModels.add(item2);
            groceryModels.add(item3);
            groceryModels.add(item4);
            groceryModels.add(item5);
            groceryModels.add(item6);
            groceryModels.add(item7);
            groceryModels.add(item8);
            groceryModels.add(item9);

        }



}
