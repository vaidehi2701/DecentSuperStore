package com.example.decentsuperstore.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.decentsuperstore.Activity.CartActivity;
import com.example.decentsuperstore.Activity.GroceryList;
import com.example.decentsuperstore.Activity.ProductList;
import com.example.decentsuperstore.Model.CategoryModel;
import com.example.decentsuperstore.R;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
    public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
        private List<CategoryModel> categories;
        private  Context context;

        public CategoryAdapter(List<CategoryModel> horizontalGrocderyList, Context context) {
            this.categories = horizontalGrocderyList;
            this.context = context;
        }

        @Override
        public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            //inflate the layout file
            View groceryProductView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid, parent, false);
            CategoryViewHolder gvh = new CategoryViewHolder(groceryProductView);
            return gvh;
        }

        @Override
        public void onBindViewHolder(CategoryViewHolder holder, final int position) {
            holder.image.setImageResource(categories.get(position).getCategoryPic());
//            holder.imageView.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    //String productName = StoryList.get(position).getProductImage().toString();
////                    // Toast.makeText(context, productName + " is selected", Toast.LENGTH_SHORT).show();
////                }
////            });
        }

        @Override
        public int getItemCount() {
            return categories.size();
        }

        public class CategoryViewHolder extends RecyclerView.ViewHolder {
            ImageView image;


            public CategoryViewHolder(View view) {
                super(view);
                context = itemView.getContext();
                image = view.findViewById(R.id.image);

                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = getAdapterPosition();

                        final Intent intent;
                        switch (position){
                            case 0:
                                intent =  new Intent(context, ProductList.class);
                                break;

                            case 1:
                                intent =  new Intent(context, GroceryList.class);
                                break;
                            case 2:
                                intent =  new Intent(context, CartActivity.class);
                                break;
                            case 3:
                                intent =  new Intent(context, CartActivity.class);
                                break;
                            case 4:
                                intent =  new Intent(context, CartActivity.class);
                                break;
                            case 5:
                                intent =  new Intent(context, CartActivity.class);
                                break;
                            default:
                                intent =  new Intent(context, CartActivity.class);
                                break;
                        }
                        context.startActivity(intent);

//                    Snackbar.make(v, "Click detected on item " + position,
//                            Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
                    }
                });
            }
        }
    }



