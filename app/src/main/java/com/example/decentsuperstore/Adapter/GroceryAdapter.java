package com.example.decentsuperstore.Adapter;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.example.decentsuperstore.Activity.GroceryList;
import com.example.decentsuperstore.Model.GroceryModel;
import com.example.decentsuperstore.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;


public class GroceryAdapter<counter> extends RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder> {

    private List<GroceryModel> groceryModels;
    private Context context;

    public GroceryAdapter(GroceryList groceryList, List<GroceryModel> groceryModels) {
        this.groceryModels = groceryModels;
    }

    @Override
    public GroceryAdapter.GroceryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_item, parent, false);

        return new GroceryAdapter.GroceryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final GroceryAdapter.GroceryViewHolder holder, int position) {
        holder.tvName.setText(groceryModels.get(position).getName());
        holder.tvWeight.setText(groceryModels.get(position).getWeight());
        holder.tvPrice.setText(groceryModels.get(position).getPrice());

        holder.ivProduct.setImageResource(groceryModels.get(position).getProductImage());
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

    @Override
    public int getItemCount() {
        return groceryModels.size();
    }


    public class GroceryViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName, tvWeight, tvPrice, integer_number;
        public Button btnIncrease, btnDecrease;
        public ImageView ivProduct;
        public CardView cardItem;
        int counter = 0;

        public GroceryViewHolder(final View view) {
            super(view);

            context = itemView.getContext();

            ivProduct = view.findViewById(R.id.ivProduct);
            cardItem = view.findViewById(R.id.cardItem);
            tvName = view.findViewById(R.id.tvName);
            tvWeight = view.findViewById(R.id.tvWeight);
            tvPrice = view.findViewById(R.id.tvPrice);
//
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                StateListAnimator stateListAnimator = AnimatorInflater
                        .loadStateListAnimator(view.getContext(), R.animator.lift_on_touch);
                cardItem.setStateListAnimator(stateListAnimator);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   // int position = getAdapterPosition();
                    Snackbar.make(v, " " + tvName.getText().toString() +" Added To Cart",
                                    Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();


//
//                    final Intent intent;
//                    switch (position) {
//                        case 0:
//                            Snackbar.make(v, "Item " + tvName.getText().toString() +" Added To Cart",
//                                    Snackbar.LENGTH_LONG)
//                                    .setAction("Action", null).show();
//                            break;
//
//                        case 1:
//                            Snackbar.make(v, "Item Added To Cart " + position,
//                                    Snackbar.LENGTH_LONG)
//                                    .setAction("Action", null).show();
//                            break;
//                        default:
//                            Snackbar.make(v, "Item Added To Cart " + position,
//                                    Snackbar.LENGTH_LONG)
//                                    .setAction("Action", null).show();
//                            break;
//                    }

//
                }
            });


            btnIncrease = view.findViewById(R.id.btnIncrease);
            btnDecrease = view.findViewById(R.id.btnDecrease);
            integer_number = view.findViewById(R.id.integer_number);
        }
    }
}
