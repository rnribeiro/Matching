package com.example.matching;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Successful extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful);
        Button ok_success_button = findViewById(R.id.ok_success_button);
        TextView success_textView = findViewById(R.id.success_textview);
        Intent previousIntent = getIntent();

        String type = previousIntent.getStringExtra("type");

        if (type.equals("Rent")){
            success_textView.setText("You have successfully rented this field");
        } else success_textView.setText("You have successfully joined this field");




        ok_success_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent success = new Intent(getApplicationContext(), MatchActivity.class);
                success.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(success);
                overridePendingTransition(0,0);
            }
        });

    }
}