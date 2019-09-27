package com.example.decentsuperstore.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.decentsuperstore.Model.BrandIcon;
import com.example.decentsuperstore.R;

import java.util.List;

public class BrandAdapter extends RecyclerView.Adapter<BrandAdapter.ViewHolder> {
        private List<BrandIcon> items;
        private Activity activity;

        public BrandAdapter(Activity activity, List<BrandIcon> items) {
            this.activity = activity;
            this.items = items;
        }

        @Override
        public BrandAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

            View brand = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid, viewGroup, false);
            BrandAdapter.ViewHolder brandcat = new BrandAdapter.ViewHolder(brand);
            return brandcat;

//
        }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.image.setImageResource(items.get(position).getDrawableId());

    }


        @Override
        public int getItemCount() {
            return items.size();
        }


        protected class ViewHolder extends RecyclerView.ViewHolder  {
            private ImageView image;
            private RelativeLayout rlMain;


            public ViewHolder(View view) {
                super(view);
                image = view.findViewById(R.id.image);
                rlMain = view.findViewById(R.id.rlMain);

            }



        }
    }

