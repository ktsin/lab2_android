package com.example.lab2_3.controllers;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.lab2_3.EditBookActivity;
import com.example.lab2_3.MainActivity;
import com.example.lab2_3.models.BookStore;

public class BookCardController {
    private final Context context;
    private final int position;
    private final BookStore store;

    public BookCardController(Context context,int position){
        this.context = context;
        store = new BookStore();
        this.position = position;

    }

    public void onDeleteClick() {
        store.remove(position);
        Toast.makeText(context, "Книга удалена!", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public void onEditClick(){
        Intent intent = new Intent(context, EditBookActivity.class);
        intent.putExtra("EditPosition", position);
        intent.putExtra("isEditingMode", true);
        context.startActivity(intent);


    }
}
