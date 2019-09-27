package com.example.decentsuperstore.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionListenerAdapter;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.decentsuperstore.Adapter.ItemAdapter;
import com.example.decentsuperstore.Model.ItemModel;
import com.example.decentsuperstore.R;

import java.util.ArrayList;
import java.util.List;

public class ProductList extends AppCompatActivity {

    private List<ItemModel> itemModels = new ArrayList<>();

    private RecyclerView rvItem;

    private ItemAdapter itemAdapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        rvItem = findViewById(R.id.rvItem);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        rvItem.setLayoutManager(layoutManager);
        itemAdapter = new ItemAdapter(this, itemModels);
        rvItem.setAdapter(itemAdapter);

        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(this, R.anim.layout_animation_left_to_right);

        rvItem.setLayoutAnimation(controller);
        rvItem.getAdapter().notifyDataSetChanged();
        rvItem.scheduleLayoutAnimation();

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
        ItemModel item1=new ItemModel("Onion","1.5 kg"," Rs. 20",R.drawable.onion);
        ItemModel item2=new ItemModel("Fresh Tometo","1 kg "," Rs. 15",R.drawable.tometo);
        ItemModel item3=new ItemModel("Green Beans","1 kg"," Rs. 45",R.drawable.green_beans);
        ItemModel item4=new ItemModel("Carrot","500 gram "," Rs. 30",R.drawable.carrot);
        ItemModel item5=new ItemModel("Lady Finger","500 gram "," Rs. 20",R.drawable.laddyfinger);
        ItemModel item6=new ItemModel("Brokoli","1-1.5 kg"," Rs. 35",R.drawable.brokoli);
        ItemModel item7=new ItemModel("Onion","1.5 kg"," Rs. 20",R.drawable.onion);
        ItemModel item8=new ItemModel("Fresh Tometo","1 kg "," Rs. 15",R.drawable.tometo);
        ItemModel item9=new ItemModel("Green Beans","1 kg"," Rs. 45",R.drawable.green_beans);

        itemModels.add(item1);
        itemModels.add(item2);
        itemModels.add(item3);
        itemModels.add(item4);
        itemModels.add(item5);
        itemModels.add(item6);
        itemModels.add(item7);
        itemModels.add(item8);
        itemModels.add(item9);

    }


}
