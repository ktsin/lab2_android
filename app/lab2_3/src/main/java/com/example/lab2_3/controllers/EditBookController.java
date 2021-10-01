package com.example.lab2_3.controllers;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.lab2_3.MainActivity;
import com.example.lab2_3.R;
import com.example.lab2_3.models.Book;
import com.example.lab2_3.models.BookStore;

public class EditBookController {
    private final BookStore store;
    private final Context context;
    private Book book;
    private boolean isEditMode;

    public EditBookController(Context context, boolean isEditMode) {
        this.isEditMode = isEditMode;
        this.store = new BookStore();
        this.context = context;

        if (!isEditMode) {

        }
    }

    public void onSubmit() {
        if(isEditMode)
            store.replace(0, book);
        else
            store.add(book);
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
                case R.id.bound_edit:
                    book.setBoundType(view.getText().toString());
                    break;
                default:
                    break;
            }
        }
        catch (Exception ex){
            Toast.makeText(context, ex.toString(), Toast.LENGTH_LONG).show();
        }
    }
}
