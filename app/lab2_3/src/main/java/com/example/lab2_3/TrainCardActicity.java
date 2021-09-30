package com.example.lab2_3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2_3.controllers.TrainCardController;
import com.example.lab2_3.models.Seat;
import com.example.lab2_3.models.Train;
import com.example.lab2_3.models.TrainStore;

public class TrainCardActicity extends AppCompatActivity {
    private TrainCardController controller;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_card_acticity);
        Intent intent = getIntent();
        int pos = intent.getIntExtra("ItemValuePosition", 0);
        TrainStore store = new TrainStore();
        Train train = store.get(pos);
        TextView line = findViewById(R.id.train_number);
        line.setText(train.getTrainNumber());
        line = findViewById(R.id.end_point);
        line.setText(train.getDestination());
        line = findViewById(R.id.departure_time);
        line.setText(train.getDepartureTime().toString());
        line = findViewById(R.id.seats);
        StringBuilder builder = new StringBuilder();
        for (Seat seat : train.getSeats()) {
            builder.append(String.format("%s : %d\n", seat.getSeatType().getName(),
                    seat.getCount()));
        }
        line.setText(builder.toString());
        controller = new TrainCardController(this, pos);
        Button btn = findViewById(R.id.delete_button);
        btn.setOnClickListener((view -> {
            controller.onDeleteClick();
        }));
        btn = findViewById(R.id.edit_button);
        btn.setOnClickListener((view)->controller.onEditClick());
    }
}