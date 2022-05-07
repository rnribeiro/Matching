package com.example.matching;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class FriendsActivity extends AppCompatActivity {
    public static ArrayList<User> friendsList = new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
    }

    private void createUsers(){
        User user1 = new User("Jon Doe", R.drawable.logo);
        User user2 = new User("Jane Doe", R.drawable.logo);
        User user3 = new User("Jack Knife", R.drawable.logo);
        User user4 = new User("Jane Knife", R.drawable.logo);
        User user5 = new User("Justin Bieber", R.drawable.logo);
        User user6 = new User("Hanna Montana", R.drawable.logo);
        User user7 = new User("Fredy Mercury", R.drawable.logo);

    }
}