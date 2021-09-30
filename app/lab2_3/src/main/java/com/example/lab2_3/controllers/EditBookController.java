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

import java.time.OffsetTime;

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
//            train = new Train("", "", OffsetTime.MIN, new ArrayList<>());
//            train.getSeats().add(new Seat(SeatType.COMMON_TYPE, 0));
//            train.getSeats().add(new Seat(SeatType.RESERVED_SEATS, 0));
//            train.getSeats().add(new Seat(SeatType.COUPE, 0));
//            train.getSeats().add(new Seat(SeatType.LUXURY, 0));
        }
    }

    public void onSubmit() {

    }

    public void onCancel() {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }

    public void onEditLostFocus(@NonNull EditText view) {
        int id = view.getId();
        switch (id) {
            default:
                break;
        }
    }
}
