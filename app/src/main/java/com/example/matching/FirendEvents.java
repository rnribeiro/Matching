package com.example.matching;

import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class FirendEvents extends AppCompatActivity {

    Button close_button_friend_events = findViewById(R.id.close_button_friend_events);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firend_events);
        Button close_button_friend_events = findViewById(R.id.close_button_friend_events);
        close_button_friend_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}