package com.example.lab2_3.controllers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2_3.MainActivity;
import com.example.lab2_3.R;
import com.example.lab2_3.models.Book;
import com.example.lab2_3.models.BookStore;

public class EditBookController {
    private final BookStore store;
    private final Context context;
    private final AppCompatActivity activity;
    private final Book book;
    private final boolean isEditMode;
    private int position = 0;

    @SuppressLint("DefaultLocale")
    public EditBookController(AppCompatActivity context, boolean isEditMode) {
        this.isEditMode = isEditMode;
        this.store = new BookStore();
        this.context = context;
        this.activity = context;
        if (isEditMode) {
            position = activity.getIntent().getIntExtra("EditPosition", 0);
            book = store.get(position);
            ((EditText) activity.findViewById(R.id.book_id_edit)).setText(book.getId());
            ((EditText) activity.findViewById(R.id.author_edit)).setText(book.getAuthor());
            ((EditText) activity.findViewById(R.id.bound_edit_)).setText(book.getBoundType());
            ((EditText) activity.findViewById(R.id.price_edit)).setText(String.format("%d.%d", book.getPrice() / 100, book.getPrice() % 100));
            ((EditText) activity.findViewById(R.id.pages_count_edit)).setText(String.format("%d", book.getPages()));
            ((EditText) activity.findViewById(R.id.year_pub_edit)).setText(book.getPublishYear());
            ((EditText) activity.findViewById(R.id.publisher_edit)).setText(book.getPublisher());
            ((EditText) activity.findViewById(R.id.book_name_edit)).setText(book.getName());
        }
        else
            book = new Book("","","","","",0,0,"");
    }

    public void onSubmit() {
        if (isEditMode){
            store.replace(position, book);
            Toast.makeText(context, "Book edited", Toast.LENGTH_LONG).show();
        }
        else {
            store.add(book);
            Toast.makeText(context, "Book added", Toast.LENGTH_LONG).show();
        }
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public void onCancel() {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }


    public void onEditLostFocus(@NonNull EditText view) {
        int id = view.getId();
        try {
            switch (id) {
                case R.id.book_id_edit:
                    book.setId(view.getText().toString());
                    break;
                case R.id.author_edit:
                    book.setAuthor(view.getText().toString());
                    break;
                case R.id.publisher_edit:
                    book.setPublisher(view.getText().toString());
                    break;
                case R.id.book_name_edit:
                    book.setName(view.getText().toString());
                    break;
                case R.id.pages_count_edit:
                    book.setPages(Integer.parseInt(view.getText().toString()));
                    break;
                case R.id.year_pub_edit:
                    book.setPublishYear(view.getText().toString());
                    break;
                case R.id.price_edit:
                    book.setPrice(Math.round(Float.parseFloat(view.getText().toString().replace(',', '.')) * 100));
                    break;
                case R.id.bound_edit_:
                    book.setBoundType(view.getText().toString());
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            Toast.makeText(context, ex.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
