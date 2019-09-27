package com.example.decentsuperstore.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.decentsuperstore.Adapter.HistoryAdapter;
import com.example.decentsuperstore.Model.HistoryModel;
import com.example.decentsuperstore.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    private RecyclerView rvHistory;
    private HistoryAdapter historyAdapter;
    private Toolbar toolbar;
    private List<HistoryModel> historyModels = new ArrayList<>();

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        rvHistory =findViewById(R.id.rvHistory);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        historyAdapter = new HistoryAdapter(historyModels);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        rvHistory.setLayoutManager(layoutManager);
        rvHistory.setItemAnimator(new DefaultItemAnimator());
        rvHistory.setAdapter(historyAdapter);

        setHistoryDtaa();
        setUpToolbar();


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

    private void setHistoryDtaa() {
        HistoryModel game = new HistoryModel("1st August 2019","In Progress","7","1500");
        historyModels.add(game);

        game = new HistoryModel("1st July 2019","Completed","6","1200");
        historyModels.add(game);

        game = new HistoryModel("15th June 2019","Completed","5","900");
        historyModels.add(game);

        game = new HistoryModel("27th April 2019","Completed","4","1359");
        historyModels.add(game);

        game = new HistoryModel("5th feburary 2019","Canceled","3","959");
        historyModels.add(game);

        game = new HistoryModel("25th December 2018","Completed","2","1250.59");
        historyModels.add(game);

        game = new HistoryModel("10th November 2018","Completed","1","1400");
        historyModels.add(game);


        historyAdapter.notifyDataSetChanged();
    }
}
