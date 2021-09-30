package com.example.lab2_3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2_3.controllers.EditBookController;

import java.util.ArrayList;
import java.util.Arrays;

public class EditBookActivity extends AppCompatActivity {
    private EditBookController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_train);
        boolean isEditMode = getIntent().getBooleanExtra("isEditingMode", false);
        controller = new EditBookController(this, isEditMode);

        Button btn = findViewById(R.id.save_button);
        btn.setOnClickListener((view -> {
            controller.onSubmit();
        }));

        btn = findViewById(R.id.cancel_button);
        btn.setOnClickListener((view) -> {
            controller.onCancel();
        });

        ArrayList<EditText> texts = new ArrayList<>(Arrays.asList(new EditText[]{
                findViewById(R.id.train_number_edit),
                findViewById(R.id.end_point_edit),
                findViewById(R.id.departure_time_edit),
                findViewById(R.id.basic_edit),
                findViewById(R.id.common_edit),
                findViewById(R.id.coupe_edit),
                findViewById(R.id.luxury_edit),
        }));
        for (EditText text : texts) {
            text.setOnFocusChangeListener(((view, b) ->
            {
                controller.onEditLostFocus((EditText) view);
            }));
        }
    }
}