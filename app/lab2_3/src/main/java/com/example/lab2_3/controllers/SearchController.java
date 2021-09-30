package com.example.lab2_3.controllers;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.lab2_3.R;
import com.example.lab2_3.models.Book;
import com.example.lab2_3.models.BookAdapter;
import com.example.lab2_3.models.BookStore;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SearchController {
    private final BookStore store;
    private final Context context;
    private boolean basicSwitch = false;
    private ArrayAdapter<String> destinations;
    private BookAdapter trains;

    public SearchController(Context context){
        this.context = context;
        store = new BookStore();
        destinations = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, store
                .getBooks()
                .stream()
                .map(Book::getDestination)
                .distinct()
                .collect(Collectors.toList()));
        trains = new BookAdapter(context, R.layout.main_list_item, new ArrayList<Book>());
    }

    public void toggleBasicSwitch() {
         basicSwitch = !basicSwitch;
    }

    public ArrayAdapter<String> getDestinations() {
        return destinations;
    }

    public BookAdapter getTrains() {
        return trains;
    }
}
