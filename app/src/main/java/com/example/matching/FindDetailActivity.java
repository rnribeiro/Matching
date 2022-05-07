package com.example.matching;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class FindDetailActivity extends AppCompatActivity {
    Field selectedField;
    Button back_from_find_dtl_btn, join_btn_dtl;

    LinearLayout find_LL_1st_left, find_LL_2nd_left,find_LL_3rd_left, find_LL_4rd_left, find_LL_5th_left;
    LinearLayout find_LL_1st_right, find_LL_2nd_right,find_LL_3rd_right, find_LL_4th_right, find_LL_5th_right;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_detail);
        getSelectedField();
        setValues();

        

        setOnClickListeners();

    }


    private void initializeWidgets() {
        back_from_find_dtl_btn = findViewById(R.id.back_from_find_dtl_btn);
        join_btn_dtl = findViewById(R.id.join_btn_dtl);

        find_LL_1st_left = findViewById(R.id.find_LL_1st_left);
        find_LL_2nd_left = findViewById(R.id.find_LL_2nd_left);
        find_LL_3rd_left = findViewById(R.id.find_LL_3rd_left);
        find_LL_4rd_left = findViewById(R.id.find_LL_4rd_left);
        find_LL_5th_left = findViewById(R.id.find_LL_5th_left);
        find_LL_1st_right = findViewById(R.id.find_LL_1st_right);
        find_LL_2nd_right = findViewById(R.id.find_LL_2nd_right);
        find_LL_3rd_right = findViewById(R.id.find_LL_3rd_right);
        find_LL_4th_right = findViewById(R.id.find_LL_4th_right);
        find_LL_5th_right = findViewById(R.id.find_LL_5th_right);
    }

    private void changeRows() {

        if (selectedField.getSport().equals("Basketball")){
            find_LL_2nd_left.setVisibility(View.GONE);
            find_LL_4rd_left.setVisibility(View.GONE);
            find_LL_2nd_right.setVisibility(View.GONE);
            find_LL_4th_right.setVisibility(View.GONE);

            find_LL_1st_left.setVisibility(View.VISIBLE);
            find_LL_3rd_left.setVisibility(View.VISIBLE);

            find_LL_5th_left.setVisibility(View.VISIBLE);
            find_LL_1st_right.setVisibility(View.VISIBLE);

            find_LL_3rd_right.setVisibility(View.VISIBLE);

            find_LL_5th_right.setVisibility(View.VISIBLE);




        } else if (selectedField.getSport().equals("Tennis")){

            find_LL_2nd_left.setVisibility(View.GONE);
            find_LL_2nd_right.setVisibility(View.GONE);
            find_LL_4rd_left.setVisibility(View.GONE);
            find_LL_4th_right.setVisibility(View.GONE);
            find_LL_5th_left.setVisibility(View.GONE);
            find_LL_5th_right.setVisibility(View.GONE);


            if (selectedField.getCapacity()==2){
                find_LL_3rd_left.setVisibility(View.GONE);
                find_LL_3rd_right.setVisibility(View.GONE);

                find_LL_1st_left.setVisibility(View.VISIBLE);
                find_LL_1st_right.setVisibility(View.VISIBLE);


            } else {
                find_LL_1st_left.setVisibility(View.GONE);
                find_LL_1st_right.setVisibility(View.GONE);

                find_LL_3rd_left.setVisibility(View.VISIBLE);
                find_LL_3rd_right.setVisibility(View.VISIBLE);
            }

        } else {
            find_LL_1st_left.setVisibility(View.VISIBLE);
            find_LL_2nd_left.setVisibility(View.VISIBLE);
            find_LL_3rd_left.setVisibility(View.VISIBLE);
            find_LL_4rd_left.setVisibility(View.VISIBLE);
            find_LL_5th_left.setVisibility(View.VISIBLE);
            find_LL_1st_right.setVisibility(View.VISIBLE);
            find_LL_2nd_right.setVisibility(View.VISIBLE);
            find_LL_3rd_right.setVisibility(View.VISIBLE);
            find_LL_4th_right.setVisibility(View.VISIBLE);
            find_LL_5th_right.setVisibility(View.VISIBLE);
        }
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