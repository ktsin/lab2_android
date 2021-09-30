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
            case R.id.train_number_edit:
                book.setTrainNumber(view.getText().toString());
                break;
            case R.id.end_point_edit: {
                try {
                    OffsetTime time = OffsetTime.parse(view.getText()+"+03:00");
                    book.setDepartureTime(time);
                } catch (Exception exception) {
                    Toast
                            .makeText(context, "Error in parsing. Format ##:##+####", Toast.LENGTH_LONG)
                            .show();
                }
            }
            break;
            case R.id.basic_edit:
                try {
                    book.getSeats().stream()
                            .filter((seat -> seat.getSeatType() == SeatType.COMMON_TYPE))
                            .findFirst()
                            .get().setCount(Integer.parseInt(view.getText().toString()));
                } catch (Exception ex) {
                    Toast
                            .makeText(context, ex.getMessage(), Toast.LENGTH_LONG)
                            .show();
                }
                break;
            case R.id.common_edit:
                try {
                    book.getSeats().stream()
                            .filter((seat -> seat.getSeatType() == SeatType.RESERVED_SEATS))
                            .findFirst()
                            .get().setCount(Integer.parseInt(view.getText().toString()));
                } catch (Exception ex) {
                    Toast
                            .makeText(context, ex.getMessage(), Toast.LENGTH_LONG)
                            .show();
                }
                break;
            case R.id.coupe_edit:

                try {
                    book.getSeats().stream()
                            .filter((seat -> seat.getSeatType() == SeatType.COUPE))
                            .findFirst()
                            .get().setCount(Integer.parseInt(view.getText().toString()));
                } catch (Exception ex) {
                    Toast
                            .makeText(context, ex.getMessage(), Toast.LENGTH_LONG)
                            .show();
                }
                break;
            case R.id.luxury_edit:
                try {
                    book.getSeats().stream()
                            .filter((seat -> seat.getSeatType() == SeatType.LUXURY))
                            .findFirst()
                            .get().setCount(Integer.parseInt(view.getText().toString()));
                } catch (Exception ex) {
                    Toast
                            .makeText(context, ex.getMessage(), Toast.LENGTH_LONG)
                            .show();
                }
                break;
            default:
                break;
        }
    }
}
