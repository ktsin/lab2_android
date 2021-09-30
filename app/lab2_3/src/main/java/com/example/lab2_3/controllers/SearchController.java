package com.example.lab2_3.controllers;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.lab2_3.R;
import com.example.lab2_3.models.Train;
import com.example.lab2_3.models.TrainAdapter;
import com.example.lab2_3.models.TrainStore;

import java.time.OffsetTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SearchController {
    private final TrainStore store;
    private final Context context;
    private boolean basicSwitch = false;
    private ArrayAdapter<String> destinations;
    private TrainAdapter trains;

    public SearchController(Context context){
        this.context = context;
        store = new TrainStore();
        destinations = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, store
                .getTrains()
                .stream()
                .map(Train::getDestination)
                .distinct()
                .collect(Collectors.toList()));
        trains = new TrainAdapter(context, R.layout.main_list_item, new ArrayList<Train>());
    }

    public void toggleBasicSwitch() {
         basicSwitch = !basicSwitch;
    }

    public ArrayAdapter<String> getDestinations() {
        return destinations;
    }

    public TrainAdapter getTrains() {
        return trains;
    }
}
