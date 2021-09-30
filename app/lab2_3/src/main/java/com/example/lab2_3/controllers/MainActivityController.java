package com.example.lab2_3.controllers;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.lab2_3.EditBookActivity;
import com.example.lab2_3.R;
import com.example.lab2_3.SearchActivity;
import com.example.lab2_3.BookCardActicity;
import com.example.lab2_3.models.BookAdapter;
import com.example.lab2_3.models.BookStore;

public class MainActivityController {
    private final BookStore store;
    private final BookAdapter adapter;
    private final Context context;

    public MainActivityController(Context context){
        store = new BookStore();
        adapter = new BookAdapter(context, R.layout.main_list_item, store.getBooks());
        this.context = context;
    }

    public void searchClick(View view){
        Intent intent = new Intent(context, SearchActivity.class);


        context.startActivity(intent);
    }

    public void addClick(View view){
        Intent intent = new Intent(context, EditBookActivity.class);
        intent.putExtra("isEditingMode", false);
        context.startActivity(intent);
    }

    public void onItemClicked(int position){
        Intent intent = new Intent(context, BookCardActicity.class);
        intent.putExtra("ItemValuePosition", position);
        intent.putExtra("ItemValue", store.get(position));
        context.startActivity(intent);

    }


    public BookAdapter getAdapter() {
        return adapter;
    }
}
