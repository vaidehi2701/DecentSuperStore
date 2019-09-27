package com.example.decentsuperstore.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.decentsuperstore.Model.CartModel;
import com.example.decentsuperstore.R;

import java.util.List;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.GameViewHolder>{

    private List<CartModel> cartList;

    public CartAdapter(List<CartModel> cartList, Context applicationContext) {
        this.cartList = cartList;
    }

    @Override
    public CartAdapter.GameViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart, parent, false);

        return new CartAdapter.GameViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CartAdapter.GameViewHolder holder, final int position) {
        holder.tvProductName.setText(cartList.get(position).getProductName());
        holder.tvProductWeigt.setText(cartList.get(position).getProductWeight());
        holder.tvProductPrice.setText(cartList.get(position).getProductPrice());
        holder.ivProductImage.setImageResource(cartList.get(position).getProductImage());
        holder.ivRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String itemLabel = String.valueOf(cartList.get(position));
                cartList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position,cartList.size());

            }
        });
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    public class GameViewHolder extends RecyclerView.ViewHolder {
        public TextView tvProductName,tvProductWeigt,tvProductPrice;
        public ImageView ivProductImage,ivRemove;

        public GameViewHolder(View view) {
            super(view);
            ivProductImage = view.findViewById(R.id.ivProductImage);
            tvProductName = view.findViewById(R.id.tvProductName);
            tvProductWeigt = view.findViewById(R.id.tvProductWeigt);
            tvProductPrice = view.findViewById(R.id.tvProductPrice);
            ivRemove = view.findViewById(R.id.ivRemove);

        }
    }

}

