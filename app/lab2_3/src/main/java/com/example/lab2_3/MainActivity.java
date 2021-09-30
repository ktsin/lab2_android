package com.example.lab2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.lab2_3.controllers.MainActivityController;

public class MainActivity extends AppCompatActivity {
    private MainActivityController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controller = new MainActivityController(this);
        setContentView(R.layout.activity_main);
        Button search = (Button) findViewById(R.id.search_button);
        Button add = (Button) findViewById(R.id.add_button);

        search.setOnClickListener((view)->{
            controller.searchClick(view);
        });
        add.setOnClickListener((view)->{
            controller.addClick(view);
        });

        ListView list = (ListView) findViewById(R.id.train_list);
        list.setAdapter(controller.getAdapter());

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                controller.onItemClicked(i);
            }
        });

    }


}