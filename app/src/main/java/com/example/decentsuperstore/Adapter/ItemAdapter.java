package com.example.decentsuperstore.Adapter;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Build;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionListenerAdapter;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.decentsuperstore.Activity.CartActivity;
import com.example.decentsuperstore.Activity.DetailActivity;
import com.example.decentsuperstore.Activity.ProductList;
import com.example.decentsuperstore.Model.ItemModel;
import com.example.decentsuperstore.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ItemAdapter<counter> extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<ItemModel> ItemList;
    private Context context;

    public ItemAdapter(ProductList productList, List<ItemModel> itemList) {
        this.ItemList = itemList;
    }

    @Override
    public ItemAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_item, parent, false);

        return new ItemAdapter.ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ItemAdapter.ItemViewHolder holder, int position) {
        holder.tvName.setText(ItemList.get(position).getName());
        holder.tvWeight.setText(ItemList.get(position).getWeight());
        holder.tvPrice.setText(ItemList.get(position).getPrice());
        holder.ivProduct.setImageResource(ItemList.get(position).getProductImage());
        holder.integer_number.setText("0");

        holder.btnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.counter = holder.counter + 1;
                holder.integer_number.setText(String.valueOf(holder.counter));
            }
        });
        holder.btnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.counter = holder.counter - 1;
                holder.integer_number.setText(String.valueOf(holder.counter));
            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)



    @Override
    public int getItemCount() {
        return ItemList.size();
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvWeight, tvPrice, integer_number,tvCart;
        public Button btnIncrease, btnDecrease;
        public ImageView ivProduct;
        public CardView cardItem;
        int counter = 0;

        public ItemViewHolder(final View view) {
            super(view);

            context = itemView.getContext();

            ivProduct = view.findViewById(R.id.ivProduct);
            cardItem = view.findViewById(R.id.cardItem);
            tvCart = view.findViewById(R.id.tvCart);
            tvName = view.findViewById(R.id.tvName);
            tvWeight = view.findViewById(R.id.tvWeight);
            tvPrice = view.findViewById(R.id.tvPrice);
//
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                StateListAnimator stateListAnimator = AnimatorInflater
                        .loadStateListAnimator(view.getContext() , R.animator.lift_on_touch);
                cardItem.setStateListAnimator(stateListAnimator);
            }

            tvCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    int position = getAdapterPosition();
                    String Name = tvName.getText().toString();
                    String Weight = tvWeight.getText().toString();
                    String Price = tvPrice.getText().toString();
                    //int Image = ivProduct.getDrawable().toString();

                    Snackbar.make(view, " " + tvName.getText().toString() +" Added To Cart",
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();

                    final Intent intent;
                    switch (position){
                        case 0:
                            intent =  new Intent(context, DetailActivity.class);
                            break;

                        case 1:
                            intent =  new Intent(context, DetailActivity.class);
                            break;
                        default:
                            intent =  new Intent(context, DetailActivity.class);
                            break;
                    }
                    context.startActivity(intent);

//                    Snackbar.make(v, "Click detected on item " + position,
//                            Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
                }
            });


            btnIncrease = view.findViewById(R.id.btnIncrease);
            btnDecrease = view.findViewById(R.id.btnDecrease);
            integer_number = view.findViewById(R.id.integer_number);
        }
    }
}






