package com.example.lab2_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;

import com.example.lab2_3.controllers.SearchController;

public class SearchActivity extends AppCompatActivity {
    private SearchController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        controller = new SearchController(this);
        findViewById(R.id.basic_switch)
                .setOnClickListener((view -> controller.toggleBasicSwitch()));
        ((AppCompatSpinner)findViewById(R.id.destination_spinner))
                .setAdapter(controller.getDestinations());
    }
}