package com.example.matching;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class RentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);

        Button go_to_find_tab_item = findViewById(R.id.go_to_find_tab_item);
        go_to_find_tab_item.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent test = new Intent(getApplicationContext(), LoginActivity.class);
                test.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(test);
                overridePendingTransition(0,0);
            }
        });


    }


}