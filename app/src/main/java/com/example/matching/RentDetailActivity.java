package com.example.matching;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RentDetailActivity extends AppCompatActivity {
    Field selectedField;
    Button back_from_rent_dtl_btn, rent_btn_dtl;
    LinearLayout rent_LL_1st_left, rent_LL_2nd_left,rent_LL_3rd_left, rent_LL_4rd_left, rent_LL_5th_left;
    LinearLayout rent_LL_1st_right, rent_LL_2nd_right,rent_LL_3rd_right, rent_LL_4th_right, rent_LL_5th_right;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_detail);
        initializeWidgets();
        getSelectedField();
        changeRows();
        setValues();


        setOnClickListeners();



    }

    private void initializeWidgets() {
        back_from_rent_dtl_btn = findViewById(R.id.back_from_rent_dtl_btn);
        rent_btn_dtl = findViewById(R.id.rent_btn_dtl);

        rent_LL_1st_left = findViewById(R.id.rent_LL_1st_left);
        rent_LL_2nd_left = findViewById(R.id.rent_LL_2nd_left);
        rent_LL_3rd_left = findViewById(R.id.rent_LL_3rd_left);
        rent_LL_4rd_left = findViewById(R.id.rent_LL_4rd_left);
        rent_LL_5th_left = findViewById(R.id.rent_LL_5th_left);
        rent_LL_1st_right = findViewById(R.id.rent_LL_1st_right);
        rent_LL_2nd_right = findViewById(R.id.rent_LL_2nd_right);
        rent_LL_3rd_right = findViewById(R.id.rent_LL_3rd_right);
        rent_LL_4th_right = findViewById(R.id.rent_LL_4th_right);
        rent_LL_5th_right = findViewById(R.id.rent_LL_5th_right);
    }

    private void changeRows() {

        if (selectedField.getSport().equals("Basketball")){
            rent_LL_2nd_left.setVisibility(View.GONE);
            rent_LL_4rd_left.setVisibility(View.GONE);
            rent_LL_2nd_right.setVisibility(View.GONE);
            rent_LL_4th_right.setVisibility(View.GONE);

            rent_LL_1st_left.setVisibility(View.VISIBLE);
            rent_LL_3rd_left.setVisibility(View.VISIBLE);

            rent_LL_5th_left.setVisibility(View.VISIBLE);
            rent_LL_1st_right.setVisibility(View.VISIBLE);

            rent_LL_3rd_right.setVisibility(View.VISIBLE);

            rent_LL_5th_right.setVisibility(View.VISIBLE);




        } else if (selectedField.getSport().equals("Tennis")){

            rent_LL_2nd_left.setVisibility(View.GONE);
            rent_LL_2nd_right.setVisibility(View.GONE);
            rent_LL_4rd_left.setVisibility(View.GONE);
            rent_LL_4th_right.setVisibility(View.GONE);
            rent_LL_5th_left.setVisibility(View.GONE);
            rent_LL_5th_right.setVisibility(View.GONE);


            if (selectedField.getCapacity()==2){
                rent_LL_3rd_left.setVisibility(View.GONE);
                rent_LL_3rd_right.setVisibility(View.GONE);

                rent_LL_1st_left.setVisibility(View.VISIBLE);
                rent_LL_1st_right.setVisibility(View.VISIBLE);


            } else {
                rent_LL_1st_left.setVisibility(View.GONE);
                rent_LL_1st_right.setVisibility(View.GONE);

                rent_LL_3rd_left.setVisibility(View.VISIBLE);
                rent_LL_3rd_right.setVisibility(View.VISIBLE);
            }

        } else {
            rent_LL_1st_left.setVisibility(View.VISIBLE);
            rent_LL_2nd_left.setVisibility(View.VISIBLE);
            rent_LL_3rd_left.setVisibility(View.VISIBLE);
            rent_LL_4rd_left.setVisibility(View.VISIBLE);
            rent_LL_5th_left.setVisibility(View.VISIBLE);
            rent_LL_1st_right.setVisibility(View.VISIBLE);
            rent_LL_2nd_right.setVisibility(View.VISIBLE);
            rent_LL_3rd_right.setVisibility(View.VISIBLE);
            rent_LL_4th_right.setVisibility(View.VISIBLE);
            rent_LL_5th_right.setVisibility(View.VISIBLE);
        }
    }

    private void setOnClickListeners() {
        back_from_rent_dtl_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rent_btn_dtl.setOnClickListener(new View.OnClickListener() {
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