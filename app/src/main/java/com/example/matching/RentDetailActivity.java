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
        TextView tv = (TextView) findViewById(R.id.rent_dtl_field_name);
        ImageView iv = (ImageView) findViewById(R.id.rent_dtl_field_image);

        tv.setText(selectedField.getName());
        iv.setImageResource(selectedField.getImage());
    }
}