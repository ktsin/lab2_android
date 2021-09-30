package com.example.lab2_3;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2_3.controllers.BookCardController;
import com.example.lab2_3.models.Book;
import com.example.lab2_3.models.BookStore;

public class BookCardActicity extends AppCompatActivity {
    private BookCardController controller;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_card_acticity);
        Intent intent = getIntent();
        int pos = intent.getIntExtra("ItemValuePosition", 0);
        BookStore store = new BookStore();
        Book book = store.get(pos);
        TextView line = findViewById(R.id.book_id);
        line.setText(book.getId());
        line = findViewById(R.id.book_name);
        line.setText(book.getName());
        line = findViewById(R.id.author);
        line.setText(book.getAuthor());
        line = findViewById(R.id.publisher);
        line.setText(book.getPublisher());
        line = findViewById(R.id.year);
        line.setText(book.getPublishYear());
        line = findViewById(R.id.pages);
        line.setText(book.getPages());
        line = findViewById(R.id.price);
        line.setText(String.format("%d.%2d",
                book.getPrice() / 100,
                book.getPrice() % 100));
        line = findViewById(R.id.bound);
        line.setText(book.getBoundType());


        controller = new BookCardController(this, pos);
        Button btn = findViewById(R.id.delete_button);
        btn.setOnClickListener((view -> {
            controller.onDeleteClick();
        }));
        btn = findViewById(R.id.edit_button);
        btn.setOnClickListener((view)->controller.onEditClick());
    }
}