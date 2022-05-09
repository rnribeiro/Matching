package com.example.matching;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class NoEvents extends AppCompatActivity {
    Button back_no_events_btn, add_events_float_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_events);

        initializeWidgets();
        setOnClickListeners();

    }

    private void setOnClickListeners() {

        back_no_events_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        add_events_float_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent add_events = new Intent(getApplicationContext(), MatchActivity.class);
                add_events.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(add_events);
                overridePendingTransition(0,0);
            }
        });

    }

    private void initializeWidgets() {

        back_no_events_btn = findViewById(R.id.back_no_events_btn);
        add_events_float_btn = findViewById(R.id.add_events_float_btn);
    }
}