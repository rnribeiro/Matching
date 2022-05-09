package com.example.matching;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button do_login_btn = findViewById(R.id.do_login_btn);
        do_login_btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent do_login = new Intent(getApplicationContext(), MatchActivity.class);
                do_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(do_login);
                overridePendingTransition(0,0);
            }
        });

        Button go_to_friends = findViewById(R.id.go_to_friends);

        go_to_friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_to_friends = new Intent(getApplicationContext(), FriendsActivity.class);
                go_to_friends.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(go_to_friends);
                overridePendingTransition(0,0);
            }
        });

    }
}