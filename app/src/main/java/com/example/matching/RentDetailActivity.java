package com.example.matching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RentDetailActivity extends AppCompatActivity {
    Field selectedField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_detail);
        getSelectedField();
        setValues();

    }

    private void getSelectedField() {
        Intent previousIntent = getIntent();
        int parsedStringID = previousIntent.getIntExtra("id", 0);
        selectedField = MatchActivity.FieldList.get(parsedStringID);
    }

    private void setValues() {
        TextView rent_dtl_field_name = (TextView) findViewById(R.id.rent_dtl_field_name);
        ImageView rent_dtl_field_image = (ImageView) findViewById(R.id.rent_dtl_field_image);
        TextView rent_dtl_time_text_view = findViewById(R.id.rent_dtl_time_text_view);
        TextView rent_dtl_location_text_view = findViewById(R.id.rent_dtl_location_text_view);


        rent_dtl_field_name.setText(selectedField.getName());
        rent_dtl_field_image.setImageResource(selectedField.getImage());
        rent_dtl_time_text_view.setText("Time: 18:00 - 19:00");
        rent_dtl_location_text_view.setText(selectedField.getLocation());
    }
}