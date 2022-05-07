package com.example.matching;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    Field selectedField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSelectedField();
        setValues();

    }

    private void getSelectedField() {
        Intent previousIntent = getIntent();
        String parsedStringID = previousIntent.getStringExtra("id");
        selectedField = MatchActivity.FieldList.get(Integer.valueOf(parsedStringID));
    }

    private void setValues() {
        TextView tv = (TextView) findViewById(R.id.dtl_field_name);
        ImageView iv = (ImageView) findViewById(R.id.dtl_field_image);

        tv.setText(selectedField.getName());
        iv.setImageResource(selectedField.getImage());
    }
}