package com.example.decentsuperstore.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.decentsuperstore.Model.HistoryModel;
import com.example.decentsuperstore.R;

import java.util.List;

    public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>{

        private List<HistoryModel> HistoryList;

        public HistoryAdapter(List<HistoryModel> gameList) {
            this.HistoryList = gameList;
        }

        @Override
        public HistoryAdapter.HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_history, parent, false);

            return new HistoryAdapter.HistoryViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(HistoryAdapter.HistoryViewHolder holder, int position) {
            holder.tvOrderDate.setText(HistoryList.get(position).getOrderDate());
            holder.tvOrderStatus.setText(HistoryList.get(position).getOrderStatus());
            holder.tvOrderNo.setText(HistoryList.get(position).getOrderNumber());
            holder.tvOrderPrice.setText(HistoryList.get(position).getOrderPrice());

        }

        @Override
        public int getItemCount() {
            return HistoryList.size();
        }

        public class HistoryViewHolder extends RecyclerView.ViewHolder {
            public TextView tvOrderDate,tvOrderStatus,tvOrderNo,tvOrderPrice;


            public HistoryViewHolder(View view) {
                super(view);
                tvOrderDate = view.findViewById(R.id.tvOrderDate);
                tvOrderStatus = view.findViewById(R.id.tvOrderStatus);
                tvOrderNo = view.findViewById(R.id.tvOrderNo);
                tvOrderPrice = view.findViewById(R.id.tvOrderPrice);

            }
        }

    }

