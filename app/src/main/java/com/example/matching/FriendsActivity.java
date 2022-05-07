package com.example.matching;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class FriendsActivity extends AppCompatActivity {

    private ListView friendsListView;


    public static ArrayList<User> friendsList = new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        friendsListView = (ListView) findViewById(R.id.friendsListView);

        friendsListView = (ListView) findViewById(R.id.friendsListView);
        FriendsAdapter adapter = new FriendsAdapter(getApplicationContext(), 0, friendsList);
        friendsListView.setAdapter(adapter);

        friendsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                User selectUser = (User) (friendsListView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), FriendsDetailActivity.class);
                showDetail.putExtra("id", selectUser.getId());
                startActivity(showDetail);
            }
        });

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