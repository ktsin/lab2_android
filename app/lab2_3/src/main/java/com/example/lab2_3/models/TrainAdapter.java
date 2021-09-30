package com.example.lab2_3.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab2_3.R;

import java.util.List;

public class TrainAdapter extends ArrayAdapter<Train> {
    private List<Train> trains;
    private int layout;
    private LayoutInflater inflater;

    public TrainAdapter(@NonNull Context context, int resource, @NonNull List<Train> objects) {
        super(context, resource, objects);
        trains = objects;
        layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = inflater.inflate(this.layout, parent, false);

            TextView nameView = (TextView) view.findViewById(R.id.item_title);
            TextView capitalView = (TextView) view.findViewById(R.id.item_description);

            Train state = trains.get(position);

            nameView.setText(String.format("%s", state.getTrainNumber()));
            capitalView.setText(String.format("%s <- at %s", state.getDestination(),
                    state.getDepartureTime().toString()));

            return view;
        }
    }
