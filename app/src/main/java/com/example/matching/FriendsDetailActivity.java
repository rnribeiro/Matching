package com.example.matching;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

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