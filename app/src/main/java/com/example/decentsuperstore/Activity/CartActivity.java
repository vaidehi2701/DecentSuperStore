package com.example.decentsuperstore.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.decentsuperstore.Adapter.CartAdapter;
import com.example.decentsuperstore.Fragment.BottomAddressFragment;
import com.example.decentsuperstore.Fragment.BottomDialogFragment;
import com.example.decentsuperstore.Model.CartModel;
import com.example.decentsuperstore.R;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {

    private List<CartModel> cartModels = new ArrayList<>();

    private RecyclerView rvCartItem;
    private CartAdapter cartAdapter;
    private ImageView ivDown;
    private RelativeLayout rlPromocode;
    private Button btnCheckOut;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        rvCartItem = findViewById(R.id.rvCartItem);
        ivDown = findViewById(R.id.ivDown);
        rlPromocode = findViewById(R.id.rlPromocode);
        btnCheckOut = findViewById(R.id.btnCheckOut);
        int resId = R.anim.layout_animation_fall_down;

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        ivDown.setOnClickListener(this);
        rlPromocode.setOnClickListener(this);
        btnCheckOut.setOnClickListener(this);

        cartAdapter = new CartAdapter(cartModels, getApplicationContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(CartActivity.this, RecyclerView.VERTICAL, false);

        rvCartItem.setLayoutManager(linearLayoutManager);
        rvCartItem.setAdapter(cartAdapter);

        runLayoutAnimation(rvCartItem);

        setUpToolbar();
        AddItemToCart();
    }

    private void runLayoutAnimation(final RecyclerView recyclerView) {
        final Context context = recyclerView.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivDown:
                Toast.makeText(this, "fdf", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rlPromocode:
                BottomDialogFragment bottomSheetDialog = BottomDialogFragment.getInstance();
                bottomSheetDialog.show(getSupportFragmentManager(), "Custom Bottom Sheet");
                break;
            case R.id.btnCheckOut:
                BottomAddressFragment bottomAddressFragment = BottomAddressFragment.getInstance();
                bottomAddressFragment.show(getSupportFragmentManager(), " Bottom Sheet For Address");
                break;


        }

    }

    private void setUpToolbar() {

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }


        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

    private void AddItemToCart() {
        CartModel cat1 = new CartModel(R.drawable.onion, "Onion", "500 gram", "25.0");
        CartModel cat2 = new CartModel(R.drawable.green_beans, "Groundnut Oil", "600 gram", "30.0");
        CartModel cat3 = new CartModel(R.drawable.tometo, "Fresh Bread", "approx 8-10 pcs", "40.0");
        CartModel cat4 = new CartModel(R.drawable.laddyfinger, "Parle-G", "500 gram", "10.0");
        CartModel cat5 = new CartModel(R.drawable.brokoli, "DairyMilk", "8 pcs", "200.0");
        CartModel cat6 = new CartModel(R.drawable.ic_bread, "Shimla Apple", "1 kg", "170.0");

        cartModels.add(cat1);
        cartModels.add(cat2);
        cartModels.add(cat3);
        cartModels.add(cat4);
        cartModels.add(cat5);
        cartModels.add(cat6);

    }


}
