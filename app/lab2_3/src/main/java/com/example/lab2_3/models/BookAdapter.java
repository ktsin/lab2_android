package com.example.lab2_3.models;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab2_3.R;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {
    private List<Book> books;
    private int layout;
    private LayoutInflater inflater;

    public BookAdapter(@NonNull Context context, int resource, @NonNull List<Book> objects) {
        super(context, resource, objects);
        books = objects;
        layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @SuppressLint("DefaultLocale")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            @SuppressLint("ViewHolder") View view = inflater.inflate(this.layout, parent, false);

            TextView nameView = (TextView) view.findViewById(R.id.item_title);
            TextView capitalView = (TextView) view.findViewById(R.id.item_description);

            Book state = books.get(position);

            nameView.setText(String.format("%s", state.getName()));
            capitalView.setText(String.format("%s; %d pages", state.getAuthor(),
                    state.getPages()));

            return view;
        }
    }
