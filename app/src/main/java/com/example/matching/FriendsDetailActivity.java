package com.example.matching;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class FriendsDetailActivity extends AppCompatActivity {
    User selectedUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_detail);

       getSelectedUser();
       setValues();
    }

    private void getSelectedUser() {
        Intent previousIntent = getIntent();
        int parsedStringID = previousIntent.getIntExtra("id", 0);
        selectedUser = FriendsActivity.friendsList.get(parsedStringID);
    }

    private void setValues() {
//        TextView rent_dtl_field_name = (TextView) findViewById(R.id.rent_dtl_field_name);
//        ImageView rent_dtl_field_image = (ImageView) findViewById(R.id.rent_dtl_field_image);
//        TextView rent_dtl_time_text_view = findViewById(R.id.rent_dtl_time_text_view);
//        TextView rent_dtl_location_text_view = findViewById(R.id.rent_dtl_location_text_view);
//
//
//        rent_dtl_field_name.setText(selectedField.getName());
//        rent_dtl_field_image.setImageResource(selectedField.getImage());
//        rent_dtl_time_text_view.setText("Time: 18:00 - 19:00");
//        rent_dtl_location_text_view.setText(selectedField.getLocation());
    }
}