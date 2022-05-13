package com.example.matching;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FriendEvents extends AppCompatActivity {
    public static ArrayList<Field> eventsList = new ArrayList<Field>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_events);
        createFields();
        Button close_button_friend_events = findViewById(R.id.close_button_friend_events);
        close_button_friend_events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        setUpMenu();
        for (int i=0;i<MatchActivity.FieldList.size();i++){
            if (MatchActivity.FieldList.get(i).getMatching_type().equals("Find")){
                eventsList.add(MatchActivity.FieldList.get(i));
            }
        }


        ListView eventsListView = (ListView) findViewById(R.id.eventsListView);
        FieldAdapter adapter = new FieldAdapter(getApplicationContext(), 0, eventsList);
        eventsListView.setAdapter(adapter);

        eventsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Field selectField = (Field) (eventsListView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), FindDetailActivity.class);
                showDetail.putExtra("id", selectField.getId());
                showDetail.putExtra("previous", 1);
                startActivity(showDetail);

            }
        });


    }

    private void createFields() {
        Field field8 = new Field("Football field", R.drawable.campo_futebol_campo_pequeno, "Lisbon", "Football", "Find", 22, 22, true);
        addToLists(field8);
        Field field9 = new Field("Basketball Porto", R.drawable.campo_basket_porto, "Porto", "Basketball", "Find", 10, 22, true);
        addToLists(field9);


    }

    private void addToLists(Field field) {
        MatchActivity.FieldList.add(field);
    }

    private void setUpMenu() {
        ImageButton menu_icon_btn = findViewById(R.id.menu_icon_btn);

        CardView menuCardView = findViewById(R.id.menuCardView);
        menu_icon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.VISIBLE);
                menuCardView.bringToFront();
            }
        });

        ImageButton hide_menu_icon_btn = findViewById(R.id.hide_menu_icon_btn);

        hide_menu_icon_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.GONE);
            }
        });

        Button button_rent = findViewById(R.id.button_rent);
        button_rent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.GONE);
                Intent go_to_login = new Intent(getApplicationContext(), MatchActivity.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                go_to_login.putExtra("Type", "Rent");
                startActivity(go_to_login);
                overridePendingTransition(0, 0);
            }
        });

        Button button_join = findViewById(R.id.button_join);
        button_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.GONE);
                Intent go_to_login = new Intent(getApplicationContext(), MatchActivity.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                go_to_login.putExtra("Type", "Find");
                startActivity(go_to_login);
                overridePendingTransition(0, 0);
            }
        });

        Button button_tournaments = findViewById(R.id.button_tournaments);
        button_tournaments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.GONE);
                Intent go_to_login = new Intent(getApplicationContext(), MatchActivity.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                go_to_login.putExtra("Type", "Tournament");
                startActivity(go_to_login);
                overridePendingTransition(0, 0);
            }
        });


        Button button_Friends = findViewById(R.id.button_Friends);
        button_Friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.GONE);
                Intent go_to_login = new Intent(getApplicationContext(), FriendsActivity.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(go_to_login);
                overridePendingTransition(0, 0);
            }
        });

        Button button_account = findViewById(R.id.button_account);
        button_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.GONE);
                Intent go_to_login = new Intent(getApplicationContext(), FunctionalityNotImplemented.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(go_to_login);
                overridePendingTransition(0, 0);
            }
        });

        Button button_logout = findViewById(R.id.button_logout);
        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.GONE);
                Intent go_to_login = new Intent(getApplicationContext(), MainActivity.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(go_to_login);
                overridePendingTransition(0, 0);
            }
        });

        FloatingActionButton button_configuration = findViewById(R.id.button_configuration);
        button_configuration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuCardView.setVisibility(v.GONE);
                Intent go_to_login = new Intent(getApplicationContext(), FunctionalityNotImplemented.class);
                go_to_login.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(go_to_login);
                overridePendingTransition(0, 0);
            }
        });


    }
}