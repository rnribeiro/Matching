package com.example.matching;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Successful extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful);
        Button ok_success_button = findViewById(R.id.ok_success_button);
        TextView success_textView = findViewById(R.id.success_textview);
        Intent previousIntent = getIntent();
//        setUpMenu();
        String type = previousIntent.getStringExtra("type");

        if (type.equals("Rent")){
            success_textView.setText("You have successfully rented this field");
        } else success_textView.setText("You have successfully joined this field");




        ok_success_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent success = new Intent(getApplicationContext(), MatchActivity.class);
                success.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                success.putExtra("Type", "Rent");
                startActivity(success);
                overridePendingTransition(0,0);
            }
        });


    }

/*    private void setUpMenu() {
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
                menuCardView.setVisibility(v.GONE);
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
                menuCardView.setVisibility(v.GONE);
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
                menuCardView.setVisibility(v.GONE);
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
                menuCardView.setVisibility(v.GONE);
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
                menuCardView.setVisibility(v.GONE);
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
                menuCardView.setVisibility(v.GONE);
                Intent go_to_login = new Intent(getApplicationContext(), MainActivity.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(go_to_login);
                overridePendingTransition(0,0);
            }
        });

        FloatingActionButton button_configuration = findViewById(R.id.button_configuration);
        button_configuration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.GONE);
                Intent go_to_login = new Intent(getApplicationContext(), FunctionalityNotImplemented.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(go_to_login);
                overridePendingTransition(0,0);
            }
        });




    }*/
}