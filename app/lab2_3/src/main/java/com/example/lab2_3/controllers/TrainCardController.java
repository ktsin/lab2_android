package com.example.lab2_3.controllers;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.lab2_3.EditTrainActivity;
import com.example.lab2_3.MainActivity;
import com.example.lab2_3.models.TrainStore;
import com.google.android.material.snackbar.Snackbar;

public class TrainCardController {
    private final Context context;
    private final int position;
    private final TrainStore store;

    public TrainCardController(Context context,int position){
        this.context = context;
        store = new TrainStore();
        this.position = position;

    }

    public void onDeleteClick() {
        store.remove(position);
        Toast.makeText(context, "Поезд удалён!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public void onEditClick(){
        Intent intent = new Intent(context, EditTrainActivity.class);
        intent.putExtra("EditPosition", position);
        context.startActivity(intent);


    }
}
