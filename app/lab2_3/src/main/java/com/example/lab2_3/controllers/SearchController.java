package com.example.lab2_3.controllers;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.lab2_3.R;
import com.example.lab2_3.models.Book;
import com.example.lab2_3.models.BookAdapter;
import com.example.lab2_3.models.BookStore;

import java.util.ArrayList;
import java.util.Observer;
import java.util.stream.Collectors;

public class SearchController {
    private final BookStore store;
    private final Context context;
    private boolean authorSwitch = false;
    private boolean publisherSwitch = false;
    private boolean yearsSwitch = false;

    private ArrayAdapter<String> authors;
    private ArrayAdapter<String> years;
    private ArrayAdapter<String> publishers;
    private BookAdapter trains;

    public SearchController(Context context){
        this.context = context;
        store = new BookStore();
        authors = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, store
                .getBooks()
                .stream()
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList()));
        publishers = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, store
                .getBooks()
                .stream()
                .map(Book::getPublisher)
                .distinct()
                .collect(Collectors.toList()));
        years = new ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, store
                .getBooks()
                .stream()
                .map(Book::getPublishYear)
                .distinct()
                .collect(Collectors.toList()));
        trains = new BookAdapter(context, R.layout.main_list_item, new ArrayList<Book>());
    }

    public void searchClick(){

    }

    public void toggleAuthorSwitch() {
         authorSwitch = !authorSwitch;
    }

    public void togglePublisherSwitch() {
        publisherSwitch = !publisherSwitch;
    }

    public void toggleYearsSwitch() {
        yearsSwitch = !yearsSwitch;
    }

    public ArrayAdapter<String> getAuthors() {
        return authors;
    }

    public ArrayAdapter<String> getPublishers() {
        return publishers;
    }

    public ArrayAdapter<String> getYears() {
        return years;
    }

    public BookAdapter getTrains() {
        return trains;
    }
}
