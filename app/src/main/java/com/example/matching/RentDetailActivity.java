package com.example.matching;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class RentDetailActivity extends AppCompatActivity {
    Field selectedField;
    Button back_from_rent_dtl_btn, rent_btn_dtl;
    LinearLayout rent_LL_1st_left, rent_LL_2nd_left,rent_LL_3rd_left, rent_LL_4rd_left, rent_LL_5th_left;
    LinearLayout rent_LL_1st_right, rent_LL_2nd_right,rent_LL_3rd_right, rent_LL_4th_right, rent_LL_5th_right;
    ImageView left_field, right_field;
    ImageButton ibtn1, ibtn2, ibtn3, ibtn4, ibtn5, ibtn6, ibtn7, ibtn8, ibtn9, ibtn10, ibtn11, ibtn12, ibtn13, ibtn14, ibtn15, ibtn16, ibtn17, ibtn18, ibtn19, ibtn20, ibtn21, ibtn22;
    Boolean bbtn1= false; Boolean bbtn2= false; Boolean bbtn3= false; Boolean bbtn4= false; Boolean bbtn5= false; Boolean bbtn6= false; Boolean bbtn7= false; Boolean bbtn8= false; Boolean bbtn9= false; Boolean bbtn10= false; Boolean bbtn11= false; Boolean bbtn12= false; Boolean bbtn13= false; Boolean bbtn14= false; Boolean bbtn15= false; Boolean bbtn16= false; Boolean bbtn17= false; Boolean bbtn18= false; Boolean bbtn19= false; Boolean bbtn20= false; Boolean bbtn21= false; Boolean bbtn22 = false;
    ConstraintLayout pay_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent_detail);
        initializeWidgets();
        getSelectedField();
        changeRows();
        setValues();


        setOnClickListeners();

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
        back_from_rent_dtl_btn = findViewById(R.id.back_from_rent_dtl_btn);
        rent_btn_dtl = findViewById(R.id.rent_btn_dtl);
        pay_layout = findViewById(R.id.pay_layout);
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

        left_field = findViewById(R.id.left_field_image);
        right_field = findViewById(R.id.right_field_image);

        ibtn1 = (ImageButton)findViewById(R.id.rentImageButton1);
        ibtn2 = (ImageButton)findViewById(R.id.rentImageButton2);
        ibtn3 = (ImageButton)findViewById(R.id.rentImageButton3);
        ibtn4 = (ImageButton)findViewById(R.id.rentImageButton4);
        ibtn5 = (ImageButton)findViewById(R.id.rentImageButton5);
        ibtn6 = (ImageButton)findViewById(R.id.rentImageButton6);
        ibtn7 = (ImageButton)findViewById(R.id.rentImageButton7);
        ibtn8 = (ImageButton)findViewById(R.id.rentImageButton8);
        ibtn9 = (ImageButton)findViewById(R.id.rentImageButton9);
        ibtn10 = (ImageButton)findViewById(R.id.rentImageButton10);
        ibtn11 = (ImageButton)findViewById(R.id.rentImageButton11);
        ibtn12= (ImageButton)findViewById(R.id.rentImageButton12);
        ibtn13 = (ImageButton)findViewById(R.id.rentImageButton13);
        ibtn14 = (ImageButton)findViewById(R.id.rentImageButton14);
        ibtn15 = (ImageButton)findViewById(R.id.rentImageButton15);
        ibtn16 = (ImageButton)findViewById(R.id.rentImageButton16);
        ibtn17 = (ImageButton)findViewById(R.id.rentImageButton17);
        ibtn18 = (ImageButton)findViewById(R.id.rentImageButton18);
        ibtn19 = (ImageButton)findViewById(R.id.rentImageButton19);
        ibtn20 = (ImageButton)findViewById(R.id.rentImageButton20);
        ibtn21 = (ImageButton)findViewById(R.id.rentImageButton21);
        ibtn22 = (ImageButton)findViewById(R.id.rentImageButton22);

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
            left_field.setImageResource(R.drawable.basket_field);
            right_field.setImageResource(R.drawable.basket_field);




        } else if (selectedField.getSport().equals("Tennis")){

            rent_LL_2nd_left.setVisibility(View.GONE);
            rent_LL_2nd_right.setVisibility(View.GONE);
            rent_LL_4rd_left.setVisibility(View.GONE);
            rent_LL_4th_right.setVisibility(View.GONE);
            rent_LL_5th_left.setVisibility(View.GONE);
            rent_LL_5th_right.setVisibility(View.GONE);
            left_field.setImageResource(R.drawable.tenis_field);
            right_field.setImageResource(R.drawable.tenis_field);


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

        Button cancel_pay_btn = findViewById(R.id.cancel_pay_btn);
        Button pay_in_person_btn, paypal_btn;

        pay_in_person_btn=findViewById(R.id.pay_in_person_btn);
        paypal_btn=findViewById(R.id.paypal_btn);


        paypal_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confirm_rent = new Intent(getApplicationContext(), Successful.class);
                confirm_rent.putExtra("type", "Rent");
                confirm_rent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(confirm_rent);
                overridePendingTransition(0, 0);
            }
        });

        pay_in_person_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent confirm_rent = new Intent(getApplicationContext(), Successful.class);
                confirm_rent.putExtra("type", "Rent");
                confirm_rent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(confirm_rent);
                overridePendingTransition(0, 0);
            }
        });


        cancel_pay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        back_from_rent_dtl_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        rent_btn_dtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    pay_layout.setVisibility(v.VISIBLE);
            }
        });

        ibtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn1 == true){
                    ibtn1.setImageResource(R.drawable.plus_sign);
                    bbtn1=false;
                }else{
                    ibtn1.setImageResource(R.drawable.green_circle);
                    bbtn1=true;
                }
            }
        });

        ibtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn2 == true){
                    ibtn2.setImageResource(R.drawable.plus_sign);
                    bbtn2=false;
                }else{
                    ibtn2.setImageResource(R.drawable.green_circle);
                    bbtn2=true;
                }
            }
        });

        ibtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn3 == true){
                    ibtn3.setImageResource(R.drawable.plus_sign);
                    bbtn3=false;
                }else{
                    ibtn3.setImageResource(R.drawable.green_circle);
                    bbtn3=true;
                }
            }
        });

        ibtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn4 == true){
                    ibtn4.setImageResource(R.drawable.plus_sign);
                    bbtn4=false;
                }else{
                    ibtn4.setImageResource(R.drawable.green_circle);
                    bbtn4=true;
                }
            }
        });

        ibtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn5 == true){
                    ibtn5.setImageResource(R.drawable.plus_sign);
                    bbtn5=false;
                }else{
                    ibtn5.setImageResource(R.drawable.green_circle);
                    bbtn5=true;
                }
            }
        });

        ibtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn6 == true){
                    ibtn6.setImageResource(R.drawable.plus_sign);
                    bbtn6=false;
                }else{
                    ibtn6.setImageResource(R.drawable.green_circle);
                    bbtn6=true;
                }
            }
        });

        ibtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn7 == true){
                    ibtn7.setImageResource(R.drawable.plus_sign);
                    bbtn7=false;
                }else{
                    ibtn7.setImageResource(R.drawable.green_circle);
                    bbtn7=true;
                }
            }
        });

        ibtn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn8 == true){
                    ibtn8.setImageResource(R.drawable.plus_sign);
                    bbtn8=false;
                }else{
                    ibtn8.setImageResource(R.drawable.green_circle);
                    bbtn8=true;
                }
            }
        });

        ibtn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn9 == true){
                    ibtn9.setImageResource(R.drawable.plus_sign);
                    bbtn9=false;
                }else{
                    ibtn9.setImageResource(R.drawable.green_circle);
                    bbtn9=true;
                }
            }
        });

        ibtn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn10 == true){
                    ibtn10.setImageResource(R.drawable.plus_sign);
                    bbtn10=false;
                }else{
                    ibtn10.setImageResource(R.drawable.green_circle);
                    bbtn10=true;
                }
            }
        });

        ibtn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn11 == true){
                    ibtn11.setImageResource(R.drawable.plus_sign);
                    bbtn11=false;
                }else{
                    ibtn11.setImageResource(R.drawable.green_circle);
                    bbtn11=true;
                }
            }
        });

        ibtn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn12 == true){
                    ibtn12.setImageResource(R.drawable.plus_sign);
                    bbtn12=false;
                }else{
                    ibtn12.setImageResource(R.drawable.green_circle);
                    bbtn12=true;
                }
            }
        });

        ibtn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn13 == true){
                    ibtn13.setImageResource(R.drawable.plus_sign);
                    bbtn13=false;
                }else{
                    ibtn13.setImageResource(R.drawable.green_circle);
                    bbtn13=true;
                }
            }
        });

        ibtn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn14 == true){
                    ibtn14.setImageResource(R.drawable.plus_sign);
                    bbtn14=false;
                }else{
                    ibtn14.setImageResource(R.drawable.green_circle);
                    bbtn14=true;
                }
            }
        });

        ibtn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn15 == true){
                    ibtn15.setImageResource(R.drawable.plus_sign);
                    bbtn15=false;
                }else{
                    ibtn15.setImageResource(R.drawable.green_circle);
                    bbtn15=true;
                }
            }
        });

        ibtn16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn16 == true){
                    ibtn16.setImageResource(R.drawable.plus_sign);
                    bbtn16=false;
                }else{
                    ibtn16.setImageResource(R.drawable.green_circle);
                    bbtn16=true;
                }
            }
        });

        ibtn17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn17 == true){
                    ibtn17.setImageResource(R.drawable.plus_sign);
                    bbtn17=false;
                }else{
                    ibtn17.setImageResource(R.drawable.green_circle);
                    bbtn17=true;
                }
            }
        });

        ibtn18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn18 == true){
                    ibtn18.setImageResource(R.drawable.plus_sign);
                    bbtn18=false;
                }else{
                    ibtn18.setImageResource(R.drawable.green_circle);
                    bbtn18=true;
                }
            }
        });

        ibtn19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn19 == true){
                    ibtn19.setImageResource(R.drawable.plus_sign);
                    bbtn19=false;
                }else{
                    ibtn19.setImageResource(R.drawable.green_circle);
                    bbtn19=true;
                }
            }
        });

        ibtn20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn20 == true){
                    ibtn20.setImageResource(R.drawable.plus_sign);
                    bbtn20=false;
                }else{
                    ibtn20.setImageResource(R.drawable.green_circle);
                    bbtn20=true;
                }
            }
        });

        ibtn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn21 == true){
                    ibtn21.setImageResource(R.drawable.plus_sign);
                    bbtn21=false;
                }else{
                    ibtn21.setImageResource(R.drawable.green_circle);
                    bbtn21=true;
                }
            }
        });

        ibtn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bbtn22 == true){
                    ibtn22.setImageResource(R.drawable.plus_sign);
                    bbtn22=false;
                }else{
                    ibtn22.setImageResource(R.drawable.green_circle);
                    bbtn22=true;
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