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
    }


    public void go_to_tabs(View v){
        Intent do_login = new Intent(getApplicationContext(), TabsActivity.class);
        do_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(do_login);
        overridePendingTransition(0,0);
    }
}