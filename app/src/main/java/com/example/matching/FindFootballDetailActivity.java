package com.example.matching;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class FindFootballDetailActivity extends AppCompatActivity {
    Field selectedField;
    Button back_from_find_dtl_btn, join_btn_dtl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_football_detail);
        getSelectedField();
        setValues();

        back_from_find_dtl_btn = findViewById(R.id.back_from_find_dtl_btn);
        join_btn_dtl = findViewById(R.id.join_btn_dtl);

        setOnClickListeners();

    }

    private void setOnClickListeners() {
        back_from_find_dtl_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        join_btn_dtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
            }
        });
    }

    private void getSelectedField() {
        Intent previousIntent = getIntent();
        int parsedStringID = previousIntent.getIntExtra("id", 0);
        selectedField = MatchActivity.FieldList.get(parsedStringID);
    }

    private void setValues() {
        TextView find_dtl_field_name = (TextView) findViewById(R.id.find_dtl_field_name);
        ImageView find_dtl_field_image = (ImageView) findViewById(R.id.find_dtl_field_image);
        TextView find_dtl_time_text_view = findViewById(R.id.find_dtl_time_text_view);
        TextView find_dtl_location_text_view = findViewById(R.id.find_dtl_location_text_view);


        find_dtl_field_name.setText(selectedField.getName());
        find_dtl_field_image.setImageResource(selectedField.getImage());
        find_dtl_time_text_view.setText("Time: 18:00 - 19:00");
        find_dtl_location_text_view.setText(selectedField.getLocation());
    }
}