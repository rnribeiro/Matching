package com.example.matching;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;

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
                do_login.putExtra("Type", "Rent");
                startActivity(do_login);
                overridePendingTransition(0,0);
            }
        });





    }
}