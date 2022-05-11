package com.example.matching;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FriendsDetailActivity extends AppCompatActivity {
    User selectedUser;

    Button see_events_friend_detail_btn, invite_friend_detail_btn, message_friend_detail_btn, remove_friend_detail_btn, back_friend_detail_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_detail);
        initializeButtons();
        getSelectedUser();
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
    private void initializeButtons() {

        see_events_friend_detail_btn = findViewById(R.id.see_events_friend_detail_btn);
        invite_friend_detail_btn = findViewById(R.id.invite_friend_detail_btn);
        message_friend_detail_btn = findViewById(R.id.message_friend_detail_btn);
        remove_friend_detail_btn = findViewById(R.id.remove_friend_detail_btn);
        back_friend_detail_btn = findViewById(R.id.back_friend_detail_btn);

    }

    private void setOnClickListeners() {

        see_events_friend_detail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent see_friend_events_activity = new Intent(getApplicationContext(), FriendEvents.class);
                see_friend_events_activity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(see_friend_events_activity);
                overridePendingTransition(0,0);
            }
        });

        invite_friend_detail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent see_friend_events_activity = new Intent(getApplicationContext(), NoEvents.class);
                see_friend_events_activity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(see_friend_events_activity);
                overridePendingTransition(0,0);
            }
        });

        message_friend_detail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 09/05/2022 maybe pop-up
                Intent see_friend_events_activity = new Intent(getApplicationContext(), FunctionalityNotImplemented.class);
                see_friend_events_activity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(see_friend_events_activity);
                overridePendingTransition(0,0);
            }
        });

        remove_friend_detail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO: 09/05/2022 maybe implement this

                Intent see_friend_events_activity = new Intent(getApplicationContext(), FunctionalityNotImplemented.class);
                see_friend_events_activity.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(see_friend_events_activity);
                overridePendingTransition(0,0);
            }
        });

        back_friend_detail_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    private void getSelectedUser() {
        Intent previousIntent = getIntent();
        int parsedStringID = previousIntent.getIntExtra("id", 0);
        selectedUser = FriendsActivity.friendsList.get(parsedStringID);
    }

    private void setValues() {
        TextView friend_name_textview = (TextView) findViewById(R.id.friend_name_textview);
        ImageView photo_friend_imageview = (ImageView) findViewById(R.id.photo_friend_imageview);

        friend_name_textview.setText(selectedUser.getName());
        photo_friend_imageview.setImageResource(selectedUser.getPhoto());
    }
}