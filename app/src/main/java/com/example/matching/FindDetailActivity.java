package com.example.matching;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

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
        changeRows();
        setOnClickListeners();
        join_btn_dtl.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
        join_btn_dtl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.design_default_color_error));
        setUpMenu();

    }

    private void setUpMenu() {
        ImageButton menu_icon_btn = findViewById(R.id.menu_icon_btn);

        CardView menuCardView = findViewById(R.id.menuCardView);
        menu_icon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.VISIBLE);
                menuCardView.bringToFront();
            }
        });

        ImageButton hide_menu_icon_btn = findViewById(R.id.hide_menu_icon_btn);

        hide_menu_icon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.GONE);
            }
        });

        Button button_rent = findViewById(R.id.button_rent);
        button_rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_login = new Intent(getApplicationContext(), MatchActivity.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                go_to_login.putExtra("Type", "Rent");
                startActivity(go_to_login);
                overridePendingTransition(0,0);
            }
        });

        Button button_join = findViewById(R.id.button_join);
        button_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_login = new Intent(getApplicationContext(), MatchActivity.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                go_to_login.putExtra("Type", "Find");
                startActivity(go_to_login);
                overridePendingTransition(0,0);
            }
        });

        Button button_tournaments = findViewById(R.id.button_tournaments);
        button_tournaments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_login = new Intent(getApplicationContext(), MatchActivity.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                go_to_login.putExtra("Type", "Tournament");
                startActivity(go_to_login);
                overridePendingTransition(0,0);
            }
        });


        Button button_Friends = findViewById(R.id.button_Friends);
        button_Friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_login = new Intent(getApplicationContext(), FriendsActivity.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(go_to_login);
                overridePendingTransition(0,0);
            }
        });

        Button button_account = findViewById(R.id.button_account);
        button_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_login = new Intent(getApplicationContext(), FunctionalityNotImplemented.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(go_to_login);
                overridePendingTransition(0,0);
            }
        });

        Button button_logout = findViewById(R.id.button_logout);
        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_login = new Intent(getApplicationContext(), LoginActivity.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(go_to_login);
                overridePendingTransition(0,0);
            }
        });

        FloatingActionButton button_configuration = findViewById(R.id.button_configuration);
        button_configuration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_login = new Intent(getApplicationContext(), FunctionalityNotImplemented.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(go_to_login);
                overridePendingTransition(0,0);
            }
        });




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
                if(checked==false){
                    Snackbar.make(v, "Please select a position!!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {

                    Intent confirm_join = new Intent(getApplicationContext(), Successful.class);
                    confirm_join.putExtra("type", "Join");
                    confirm_join.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(confirm_join);
                    overridePendingTransition(0, 0);
                }
            }
        });



        ibtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bbtn1 == false && checked == false) {
                    ibtn1.setImageResource(R.drawable.green_circle);
                    join_btn_dtl.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
                    join_btn_dtl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.green));
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
                    join_btn_dtl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.green));
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
                    join_btn_dtl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.green));
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
                    join_btn_dtl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.green));
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
                    join_btn_dtl.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.green));
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