package com.example.lab2_3.controllers;

import android.content.Context;
import android.content.Intent;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import com.example.lab2_3.BookCardActicity;
import com.example.lab2_3.R;
import com.example.lab2_3.models.Book;
import com.example.lab2_3.models.BookAdapter;
import com.example.lab2_3.models.BookStore;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SearchController {
    private final BookStore store;
    private final Context context;
    private boolean authorSwitch = false;
    private boolean publisherSwitch = false;
    private boolean yearsSwitch = false;
    AppCompatSpinner authorSpinner;
    AppCompatSpinner publisherSpinner;
    AppCompatSpinner yearSpinner;




    private ArrayAdapter<String> authors;
    private ArrayAdapter<String> years;
    private ArrayAdapter<String> publishers;
    private BookAdapter books;

    public SearchController(AppCompatActivity activity){
        this.context = (Context) activity;

        store = new BookStore();
        authors = new ArrayAdapter<String>(activity, R.layout.support_simple_spinner_dropdown_item, store
                .getBooks()
                .stream()
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList()));
        publishers = new ArrayAdapter<String>(activity, R.layout.support_simple_spinner_dropdown_item, store
                .getBooks()
                .stream()
                .map(Book::getPublisher)
                .distinct()
                .collect(Collectors.toList()));
        years = new ArrayAdapter<String>(activity, R.layout.support_simple_spinner_dropdown_item, store
                .getBooks()
                .stream()
                .map(Book::getPublishYear)
                .distinct()
                .collect(Collectors.toList()));
        books = new BookAdapter(activity, R.layout.main_list_item, new ArrayList<Book>());
        authorSpinner = activity.findViewById(R.id.author_spinner);
        publisherSpinner = activity.findViewById(R.id.publisher_spinner);
        yearSpinner = activity.findViewById(R.id.years_spinner);

    }

    public void searchClick(){
        String selectedAuthor = authorSpinner.getSelectedItem().toString();
        String selectedPublisher = publisherSpinner.getSelectedItem().toString();
        int selectedYear = Integer.parseInt(yearSpinner.getSelectedItem().toString());
        ArrayList<Book> searchResult = (ArrayList<Book>) store.getBooks().stream().filter(e -> {
            boolean result = (!authorSwitch || e.getAuthor().contains(selectedAuthor));
            result &= (!publisherSwitch || e.getPublisher().contains(selectedPublisher));
            result &= (!yearsSwitch || Integer.parseInt(e.getPublishYear()) >= selectedYear);
            return result;
        }).collect(Collectors.toList());
        books.clear();
        books.addAll(searchResult);
        books.notifyDataSetChanged();
//        books.notifyAll();

    }

    public void onItemClicked(int position){
        Intent intent = new Intent(context, BookCardActicity.class);
        intent.putExtra("ItemValuePosition", position);
        intent.putExtra("ItemValue", books.getItem(position));
        context.startActivity(intent);

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

    public BookAdapter getBooks() {
        return books;
    }
}
