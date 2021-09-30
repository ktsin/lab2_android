package com.example.lab2_3.controllers;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.lab2_3.EditTrainActivity;
import com.example.lab2_3.R;
import com.example.lab2_3.SearchActivity;
import com.example.lab2_3.TrainCardActicity;
import com.example.lab2_3.models.TrainAdapter;
import com.example.lab2_3.models.TrainStore;

public class MainActivityController {
    private final TrainStore store;
    private final TrainAdapter adapter;
    private Context context;

    public MainActivityController(Context context){
        store = new TrainStore();
        adapter = new TrainAdapter(context, R.layout.main_list_item, store.getTrains());
        this.context = context;
    }

    public void searchClick(View view){
        Intent intent = new Intent(context, SearchActivity.class);


        context.startActivity(intent);
    }

    public void addClick(View view){
        Intent intent = new Intent(context, EditTrainActivity.class);
        intent.putExtra("isEditingMode", false);
        context.startActivity(intent);
    }

    public void onItemClicked(int position){
        Intent intent = new Intent(context, TrainCardActicity.class);
        intent.putExtra("ItemValuePosition", position);
        intent.putExtra("ItemValue", store.get(position));
        context.startActivity(intent);

    }


    public TrainAdapter getAdapter() {
        return adapter;
    }
}
