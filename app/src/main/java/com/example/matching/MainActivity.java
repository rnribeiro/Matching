package com.example.matching;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button go_to_login_btn = findViewById(R.id.go_to_login_btn);
        go_to_login_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent go_to_login = new Intent(getApplicationContext(), LoginActivity.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(go_to_login);
                overridePendingTransition(0,0);
            }
        });


    }
}