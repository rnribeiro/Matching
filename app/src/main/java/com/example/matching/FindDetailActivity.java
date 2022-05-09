package com.example.matching;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class FindDetailActivity extends AppCompatActivity {
    Field selectedField;
    Button back_from_find_dtl_btn, join_btn_dtl;

    LinearLayout find_LL_1st_left, find_LL_2nd_left,find_LL_3rd_left, find_LL_4rd_left, find_LL_5th_left;
    LinearLayout find_LL_1st_right, find_LL_2nd_right,find_LL_3rd_right, find_LL_4th_right, find_LL_5th_right;
    ImageView left_field, right_field;
    ImageButton ibtn1, ibtn2, ibtn3, ibtn4, ibtn5, ibtn6, ibtn7, ibtn8, ibtn9, ibtn10, ibtn11, ibtn12, ibtn13, ibtn14, ibtn15, ibtn16, ibtn17, ibtn18, ibtn19, ibtn20, ibtn21, ibtn22;
    Boolean checked = false;
    Boolean bbtn1 = false; Boolean bbtn5 = false; Boolean bbtn12 = false; Boolean bbtn15 = false; Boolean bbtn20 = false;

//    ImageButton findImageButton1,
//    findImageButton2,
//    findImageButton3,
//    findImageButton4,
//    findImageButton5,
//    findImageButton6,
//    findImageButton7,
//    findImageButton8,
//    findImageButton9,
//    findImageButton10,
//    findImageButton11,
//    findImageButton12,
//    findImageButton13,
//    findImageButton14,
//    findImageButton15,
//    findImageButton16,
//    findImageButton17,
//    findImageButton18,
//    findImageButton19,
//    findImageButton20,
//    findImageButton21,
//    findImageButton22;

    ArrayList<LinearLayout> rows = new ArrayList<LinearLayout>();

    ArrayList<ImageButton> imageButtons = new ArrayList<ImageButton>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_detail);
        initializeWidgets();
        getSelectedField();
        setValues();
        setOnClickListeners();
        join_btn_dtl.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
        join_btn_dtl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_error));

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

        rows.add(find_LL_1st_left);
        rows.add(find_LL_2nd_left);
        rows.add(find_LL_3rd_left);
        rows.add(find_LL_4rd_left);
        rows.add(find_LL_5th_left);
        rows.add(find_LL_1st_right);
        rows.add(find_LL_2nd_right);
        rows.add(find_LL_3rd_right);
        rows.add(find_LL_4th_right);
        rows.add(find_LL_5th_right);

        left_field = findViewById(R.id.left_field_image);
        right_field = findViewById(R.id.right_field_image);

        ibtn1 = (ImageButton)findViewById(R.id.findImageButton1);
        ibtn2 = (ImageButton)findViewById(R.id.findImageButton2);
        ibtn3 = (ImageButton)findViewById(R.id.findImageButton3);
        ibtn4 = (ImageButton)findViewById(R.id.findImageButton4);
        ibtn5 = (ImageButton)findViewById(R.id.findImageButton5);
        ibtn6 = (ImageButton)findViewById(R.id.findImageButton6);
        ibtn7 = (ImageButton)findViewById(R.id.findImageButton7);
        ibtn8 = (ImageButton)findViewById(R.id.findImageButton8);
        ibtn9 = (ImageButton)findViewById(R.id.findImageButton9);
        ibtn10 = (ImageButton)findViewById(R.id.findImageButton10);
        ibtn11 = (ImageButton)findViewById(R.id.findImageButton11);
        ibtn12= (ImageButton)findViewById(R.id.findImageButton12);
        ibtn13 = (ImageButton)findViewById(R.id.findImageButton13);
        ibtn14 = (ImageButton)findViewById(R.id.findImageButton14);
        ibtn15 = (ImageButton)findViewById(R.id.findImageButton15);
        ibtn16 = (ImageButton)findViewById(R.id.findImageButton16);
        ibtn17 = (ImageButton)findViewById(R.id.findImageButton17);
        ibtn18 = (ImageButton)findViewById(R.id.findImageButton18);
        ibtn19 = (ImageButton)findViewById(R.id.findImageButton19);
        ibtn20 = (ImageButton)findViewById(R.id.findImageButton20);
        ibtn21 = (ImageButton)findViewById(R.id.findImageButton21);
        ibtn22 = (ImageButton)findViewById(R.id.findImageButton22);


        ImageButton findImageButton1 = findViewById(R.id.findImageButton1);
        String set = "" + findImageButton1.getImportantForAccessibility();

        Log.i("set: " , set);
//        ImageButton findImageButton2 = findViewById(R.id.findImageButton2);
//        ImageButton findImageButton3 = findViewById(R.id.findImageButton3);
//        ImageButton findImageButton4 = findViewById(R.id.findImageButton4);
//        ImageButton findImageButton5 = findViewById(R.id.findImageButton5);
//        ImageButton findImageButton6 = findViewById(R.id.findImageButton6);
//        ImageButton findImageButton7 = findViewById(R.id.findImageButton7);
//        ImageButton findImageButton8 = findViewById(R.id.findImageButton8);
//        ImageButton findImageButton9 = findViewById(R.id.findImageButton9);
//        ImageButton findImageButton10 = findViewById(R.id.findImageButton10);
//        ImageButton findImageButton11 = findViewById(R.id.findImageButton11);
//        ImageButton findImageButton12 = findViewById(R.id.findImageButton12);
//        ImageButton findImageButton13 = findViewById(R.id.findImageButton13);
//        ImageButton findImageButton14 = findViewById(R.id.findImageButton14);
//        ImageButton findImageButton15 = findViewById(R.id.findImageButton15);
//        ImageButton findImageButton16 = findViewById(R.id.findImageButton16);
//        ImageButton findImageButton17 = findViewById(R.id.findImageButton17);
//        ImageButton findImageButton18 = findViewById(R.id.findImageButton18);
//        ImageButton findImageButton19 = findViewById(R.id.findImageButton19);
//        ImageButton findImageButton20 = findViewById(R.id.findImageButton20);
//        ImageButton findImageButton21 = findViewById(R.id.findImageButton21);
//        ImageButton findImageButton22 = findViewById(R.id.findImageButton22);
//
//        imageButtons.add(findImageButton1);
//        imageButtons.add(findImageButton2);
//        imageButtons.add(findImageButton3);
//        imageButtons.add(findImageButton4);
//        imageButtons.add(findImageButton5);
//        imageButtons.add(findImageButton6);
//        imageButtons.add(findImageButton7);
//        imageButtons.add(findImageButton8);
//        imageButtons.add(findImageButton9);
//        imageButtons.add(findImageButton10);
//        imageButtons.add(findImageButton11);
//        imageButtons.add(findImageButton12);
//        imageButtons.add(findImageButton13);
//        imageButtons.add(findImageButton14);
//        imageButtons.add(findImageButton15);
//        imageButtons.add(findImageButton16);
//        imageButtons.add(findImageButton17);
//        imageButtons.add(findImageButton18);
//        imageButtons.add(findImageButton19);
//        imageButtons.add(findImageButton20);
//        imageButtons.add(findImageButton21);
//        imageButtons.add(findImageButton22);

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
            left_field.setImageResource(R.drawable.basket_field);
            right_field.setImageResource(R.drawable.basket_field);




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
                if(checked==true){
                    finish();
                }
            }
        });

        ibtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bbtn1 == false && checked == false) {
                    ibtn1.setImageResource(R.drawable.green_circle);
                    join_btn_dtl.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    join_btn_dtl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_primary));
                    checked = true;
                    bbtn1=true;
                } else if(bbtn1 == true && checked == true) {
                    ibtn1.setImageResource(R.drawable.plus_sign);
                    join_btn_dtl.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                    join_btn_dtl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_error));
                    checked = false;
                    bbtn1=false;
                } else if(bbtn1 == false && checked == true){
                    bbtn15 = false;
                    bbtn12 = false;
                    bbtn5 = false;
                    bbtn20 = false;
                    ibtn15.setImageResource(R.drawable.plus_sign);
                    ibtn12.setImageResource(R.drawable.plus_sign);
                    ibtn5.setImageResource(R.drawable.plus_sign);
                    ibtn20.setImageResource(R.drawable.plus_sign);
                    ibtn1.setImageResource(R.drawable.green_circle);
                    bbtn1=true;
                }
            }
        });

        ibtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bbtn5 == false && checked == false) {
                    ibtn5.setImageResource(R.drawable.green_circle);
                    join_btn_dtl.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    join_btn_dtl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_primary));
                    checked = true;
                    bbtn5=true;
                } else if(bbtn5 == true && checked == true) {
                    ibtn5.setImageResource(R.drawable.plus_sign);
                    join_btn_dtl.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                    join_btn_dtl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_error));
                    checked = false;
                    bbtn5=false;
                } else if(bbtn5 == false && checked == true){
                    bbtn15 = false;
                    bbtn12 = false;
                    bbtn1 = false;
                    bbtn20 = false;
                    ibtn15.setImageResource(R.drawable.plus_sign);
                    ibtn12.setImageResource(R.drawable.plus_sign);
                    ibtn1.setImageResource(R.drawable.plus_sign);
                    ibtn20.setImageResource(R.drawable.plus_sign);
                    ibtn5.setImageResource(R.drawable.green_circle);
                    bbtn5=true;
                }
            }
        });

        ibtn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bbtn12 == false && checked == false) {
                    ibtn12.setImageResource(R.drawable.green_circle);
                    join_btn_dtl.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    join_btn_dtl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_primary));
                    checked = true;
                    bbtn12=true;
                } else if(bbtn12 == true && checked == true) {
                    ibtn12.setImageResource(R.drawable.plus_sign);
                    join_btn_dtl.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                    join_btn_dtl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_error));
                    checked = false;
                    bbtn12=false;
                } else if(bbtn12 == false && checked == true){
                    bbtn15 = false;
                    bbtn1 = false;
                    bbtn5 = false;
                    bbtn20 = false;
                    ibtn15.setImageResource(R.drawable.plus_sign);
                    ibtn1.setImageResource(R.drawable.plus_sign);
                    ibtn5.setImageResource(R.drawable.plus_sign);
                    ibtn20.setImageResource(R.drawable.plus_sign);
                    ibtn12.setImageResource(R.drawable.green_circle);
                    bbtn12=true;
                }
            }
        });

        ibtn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bbtn15 == false && checked == false) {
                    ibtn15.setImageResource(R.drawable.green_circle);
                    join_btn_dtl.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    join_btn_dtl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_primary));
                    checked = true;
                    bbtn15=true;
                } else if(bbtn15 == true && checked == true) {
                    ibtn15.setImageResource(R.drawable.plus_sign);
                    join_btn_dtl.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                    join_btn_dtl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_error));
                    checked = false;
                    bbtn15=false;
                } else if(bbtn15 == false && checked == true){
                    bbtn1 = false;
                    bbtn12 = false;
                    bbtn5 = false;
                    bbtn20 = false;
                    ibtn1.setImageResource(R.drawable.plus_sign);
                    ibtn12.setImageResource(R.drawable.plus_sign);
                    ibtn5.setImageResource(R.drawable.plus_sign);
                    ibtn20.setImageResource(R.drawable.plus_sign);
                    ibtn15.setImageResource(R.drawable.green_circle);
                    bbtn15=true;
                }
            }
        });

        ibtn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bbtn20 == false && checked == false) {
                    ibtn20.setImageResource(R.drawable.green_circle);
                    join_btn_dtl.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    join_btn_dtl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_primary));
                    checked = true;
                    bbtn20=true;
                } else if(bbtn20 == true && checked == true) {
                    ibtn20.setImageResource(R.drawable.plus_sign);
                    join_btn_dtl.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                    join_btn_dtl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_error));
                    checked = false;
                    bbtn20=false;
                } else if(bbtn20 == false && checked == true){
                    bbtn15 = false;
                    bbtn12 = false;
                    bbtn5 = false;
                    bbtn1 = false;
                    ibtn15.setImageResource(R.drawable.plus_sign);
                    ibtn12.setImageResource(R.drawable.plus_sign);
                    ibtn5.setImageResource(R.drawable.plus_sign);
                    ibtn1.setImageResource(R.drawable.plus_sign);
                    ibtn20.setImageResource(R.drawable.green_circle);
                    bbtn20=true;
                }
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